package compliance.parser;

import compliance.parser.antlr.Conveyor;
import compliance.parser.antlr.csv.CsvConveyor;
import compliance.parser.antlr.csv.CsvParserImpl;
import compliance.parser.antlr.gradle.GradleConveyor;
import compliance.parser.antlr.gradle.GradleParserImpl;
import compliance.parser.antlr.graphql.GraphqlConveyor;
import compliance.parser.antlr.graphql.GraphqlParserImpl;
import compliance.parser.java.ClassParser;
import compliance.utils.Config;
import compliance.utils.JsonUtils;
import compliance.utils.Strings;
import compliance.utils.TextEnum;
import compliance.validators.Opa;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main
 *
 * @author jimmyray
 * @version 1.0
 */

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    String parserType;
    boolean debug;
    boolean warn;
    String filePath;
    String policyPath;
    String outputPath;
    ParserReturn parserReturn;
    String schemaPath;
    Conveyor conveyor;
    String wasm;

    /**
     * Main entrypoint method
     *
     * @param args array of strings
     */
    public static void main(String[] args) {
        Main main = new Main();

        // Pass through
        main.run(args);
    }

    /**
     * Main instance run method, heavy lifter
     *
     * @param args from main entry point, needed for CLI options
     */
    private void run(String[] args) {
        try {

            // CLI config
            CommandLineParser parser = new DefaultParser();
            Options options = new Options();
            options.addOption("a", "wasm", true, Config.properties.getProperty("cli.wasm.txt", TextEnum.CLI_WASM_TXT.getValue()));
            options.addOption("d", "debug", false, Config.properties.getProperty("cli.debug.txt", TextEnum.CLI_DEBUG_TXT.getValue()));
            options.addOption("f", "file", true, Config.properties.getProperty("cli.file.txt", TextEnum.CLI_FILE_TXT.getValue()));
            options.addOption("h", "help", false, Config.properties.getProperty("cli.help.txt", TextEnum.CLI_HELP_TXT.getValue()));
            options.addOption("o", "output", true, Config.properties.getProperty("cli.output.txt", TextEnum.CLI_OUTPUT_TXT.getValue()));
            options.addOption("p", "policy", true, Config.properties.getProperty("cli.policy.txt", TextEnum.CLI_POLICY_TXT.getValue()));
            options.addOption("s", "schema", true, Config.properties.getProperty("cli.schema.txt", TextEnum.CLI_SCHEMA_TXT.getValue()));
            options.addOption("t", "type", true, Config.properties.getProperty("cli.type.txt", TextEnum.CLI_TYPE_TXT.getValue()));
            options.addOption("w", "warn", false, Config.properties.getProperty("cli.warn.txt", TextEnum.CLI_WARN_TXT.getValue()));
            CommandLine commandLine = parser.parse(options, args);

            // No args, show help, then exit
            if (args.length < 1) {
                displayHelp(options);
                System.exit(1);
            }

            // Show help, then exit
            if (commandLine.hasOption("h")) {
                displayHelp(options);
                System.exit(0);
            }

            // No parser type, then exit
            if (!commandLine.hasOption("t")) {
                logger.fatal(Config.properties.getProperty("msg.parser.type.not.specd", TextEnum.MSG_PARSER_TYPE_NOT_SPECD.getValue()));
                System.exit(1);
            }

            // No file path, then exit
            if (!commandLine.hasOption("f")) {
                logger.fatal(Config.properties.getProperty("msg.file.not.specd", TextEnum.MSG_FILE_NOT_SPECD.getValue()));
                System.exit(1);
            }

            // Gather needed values from command line
            this.debug = commandLine.hasOption("d");
            this.filePath = commandLine.getOptionValue("f");
            this.outputPath = commandLine.getOptionValue("o");
            this.parserType = commandLine.getOptionValue("t");
            this.policyPath = commandLine.getOptionValue("p");
            this.schemaPath = commandLine.getOptionValue("s");
            this.warn = commandLine.hasOption("w");
            if (commandLine.hasOption("a")) {
                this.wasm = commandLine.getOptionValue("a");
            }

            if (this.debug) {
                logger.debug("{}{}", Config.properties.getProperty("msg.debug.parser.type", TextEnum.MSG_DEBUG_PARSER_TYPE.getValue()), this.parserType);
                logger.debug("{}{}", Config.properties.getProperty("msg.debug.file.path", TextEnum.MSG_DEBUG_FILE_PATH.getValue()), this.filePath);
                if (!Strings.isNullOrEmpty(this.policyPath)) {
                    logger.debug("{}{}", Config.properties.getProperty("msg.debug.policy.path", TextEnum.MSG_DEBUG_POLICY_PATH.getValue()), this.policyPath);
                }
            }

            // Switch on parser source type
            switch (this.parserType.toLowerCase()) {
                case "java":
                    // Call JavaParser API
                    this.parserReturn = ClassParser.parse(this.filePath);
                    this.handleParserReturn();

                    // Create JSON schema
                    if (!Strings.isNullOrEmpty(this.schemaPath)) {
                        String schema = ClassParser.getSchema();
                        if (this.debug) {
                            logger.debug("{}{}", Config.properties.getProperty("msg.debug.json.schema", TextEnum.MSG_DEBUG_JSON_SCHEMA.getValue()), schema);
                        }
                        this.writeFile(this.schemaPath, schema);
                    }
                    break;
                case "gradle":
                    // Call ANTLR generated parser
                    conveyor = GradleConveyor.getInstance();
                    conveyor.setFilePath(this.filePath);
                    conveyor.setDebug(this.debug);
                    GradleParserImpl.parse();
                    this.parserReturn = conveyor.getJson();
                    this.handleParserReturn();

                    // Create JSON schema
                    if (!Strings.isNullOrEmpty(this.schemaPath)) {
                        String schema = conveyor.getSchema();
                        if (this.debug) {
                            logger.debug("{}{}", Config.properties.getProperty("msg.debug.json.schema", TextEnum.MSG_DEBUG_JSON_SCHEMA.getValue()), schema);
                        }
                        this.writeFile(this.schemaPath, schema);
                    }
                    break;
                case "graphql":
                    // Call ANTLR generated parser
                    conveyor = GraphqlConveyor.getInstance();
                    conveyor.setFilePath(this.filePath);
                    conveyor.setDebug(this.debug);
                    GraphqlParserImpl.parse();
                    parserReturn = conveyor.getJson();
                    this.handleParserReturn();

                    // Create JSON schema
                    if (!Strings.isNullOrEmpty(this.schemaPath)) {
                        String schema = conveyor.getSchema();
                        if (this.debug) {
                            logger.debug("{}{}", Config.properties.getProperty("msg.debug.json.schema", TextEnum.MSG_DEBUG_JSON_SCHEMA.getValue()), schema);
                        }
                        this.writeFile(this.schemaPath, schema);
                    }
                    break;
                case "csv":
                    // Call ANTLR generated parser
                    conveyor = CsvConveyor.getInstance();
                    conveyor.setFilePath(this.filePath);
                    conveyor.setDebug(this.debug);
                    CsvParserImpl.parse();
                    this.parserReturn = conveyor.getJson();
                    this.handleParserReturn();

                    // Create JSON schema
                    if (!Strings.isNullOrEmpty(this.schemaPath)) {
                        String schema = conveyor.getSchema();
                        if (this.debug) {
                            logger.debug("{}{}", Config.properties.getProperty("msg.debug.json.schema", TextEnum.MSG_DEBUG_JSON_SCHEMA.getValue()), schema);
                        }
                        this.writeFile(this.schemaPath, schema);
                    }
                    break;
                default:
                    // Unknown parser type
                    logger.fatal("{}: {}", Config.properties.getProperty("msg.unknown.parser.type", TextEnum.MSG_UNKNOWN_PARSER_TYPE.getValue()), this.parserType);
            }
        } catch (Exception e) {
            logger.fatal(Strings.getStackTraceAsString(e));
        }
    }

    /**
     * Handle JSON parser return values
     *
     * @throws Exception general exception
     */
    private void handleParserReturn() throws Exception {
        if (debug) {
            logger.debug("{}{}", Config.properties.getProperty("msg.debug.parsed.json", TextEnum.MSG_DEBUG_PARSED_JSON.getValue()), this.parserReturn.getJson());
            logger.debug("{}{}", Config.properties.getProperty("msg.debug.parsed.map", TextEnum.MSG_DEBUG_PARSED_MAP.getValue()), this.parserReturn.getMap());
        }

        if (!Strings.isNullOrEmpty(this.policyPath)) {
            // Eval via OPA server and SDK
            List<Map<String, Object>> result = Opa.validate(this.parserReturn.getMap(), this.policyPath);
            handleValidationResult(result);
        } else if (!Strings.isNullOrEmpty(this.wasm)) {
            // Eval via OPA Wasm and SDK
            String wasmResult = Opa.validateWasm(this.parserReturn.getJson(), this.wasm);

            List<Map<String, Object>> result = new ArrayList<>();
            result.add(JsonUtils.getMapFromJsonString(wasmResult));
            handleValidationResult(result);
        } else {
            // JSON only, then exit
            // Write parsed JSON to file or STDOUT
            if (!Strings.isNullOrEmpty(this.outputPath)) {
                writeFile(this.outputPath, this.parserReturn.getJson());
            } else {
                System.out.println(this.parserReturn.getJson());
            }
        }
    }

    /**
     * Handle results from JSON validator calls
     *
     * @param result from validator calls
     * @throws Exception general exception
     */
    private void handleValidationResult(List<Map<String, Object>> result) throws Exception {
        if (this.debug) {
            logger.debug("{}: {}", Config.properties.getProperty("msg.debug.opa.result", TextEnum.MSG_DEBUG_OPA_RESULT.getValue()), result);
        }

        if (result.isEmpty()) {
            System.out.println(JsonUtils.getJsonString(JsonUtils.putMapInNode(Map.of("msg",
                    this.parserType + Config.properties.getProperty("msg.valid", TextEnum.MSG_VALID.getValue())))));
        } else {
            if (!Strings.isNullOrEmpty(this.wasm)) {
                System.out.println(
                        JsonUtils.addObjectToTree(JsonUtils.putMapInNode(Map.of("msg",
                                        this.parserType + Config.properties.getProperty("msg.invalid", TextEnum.MSG_INVALID.getValue()))),
                                result.get(0).get("result"), "result").toString()
                );
            } else {
                System.out.println(
                        JsonUtils.addObjectToTree(JsonUtils.putMapInNode(Map.of("msg",
                                        this.parserType + Config.properties.getProperty("msg.invalid", TextEnum.MSG_INVALID.getValue()))),
                                result, "result").toString()
                );
            }
        }
    }

    /**
     * Write file output
     *
     * @param filePath Path to file for writing
     * @param content  Content to write
     * @throws Exception General exception
     */
    private void writeFile(String filePath, String content)
            throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }

    /**
     * Display help
     *
     * @param options CLI options
     */
    private void displayHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CommandLineParameters", options);
    }
}