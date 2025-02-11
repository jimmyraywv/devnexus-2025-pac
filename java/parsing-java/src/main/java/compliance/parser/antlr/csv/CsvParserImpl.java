package compliance.parser.antlr.csv;

import compliance.parser.antlr.csv.gen.CSVLexer;
import compliance.parser.antlr.csv.gen.CSVParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Parse implementation to configure ANTLR parser tree, listeners, and visitors
 *
 * @author jimmyray
 * @version 1.0
 */
public class CsvParserImpl {
    private static final Logger logger = LogManager.getLogger(CsvParserImpl.class);

    /**
     * Heavy lifting of parser setup/walking/listening/visiting
     *
     * @throws Exception Generic exception
     */
    public static void parse() throws Exception {
        CsvConveyor conveyor = CsvConveyor.getInstance();
        File file = new File(conveyor.getFilePath());
        String content = IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8);

        if (conveyor.isDebug()) {
            logger.debug("CSV document content (" + conveyor.getFilePath() + "):\n\n\n" + content);
        }

        // Start the parsing process - Content -> Lexer -> tokens -> Parser -> Tree
        CSVLexer csvLexer = new CSVLexer(CharStreams.fromString(content));
        CommonTokenStream tokens = new CommonTokenStream(csvLexer);
        CSVParser parser = new CSVParser(tokens);
        ParseTree tree = parser.csvFile();
        CsvVisitorImpl visitor = new CsvVisitorImpl();
        visitor.visit(tree);
    }
}
