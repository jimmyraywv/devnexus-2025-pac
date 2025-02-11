package compliance.utils;

/**
 * CommonValues
 *
 * @author jimmyray
 * @version 1.0
 */

public enum TextEnum {
    ABSTRACT("abstract"),
    FINAL("final"),
    PROTECTED("protected"),
    STATIC("static"),
    TRANSIENT("transient"),
    VOLATILE("volatile"),
    OPA_URL("http://localhost:8181"),
    OPA_URL_KEY("opa.url"),
    OPA_BEARER_TOKEN_KEY("opa.bearer.token"),
    CLI_CONTINUE_TXT("Enables continue without config properties file"),
    CLI_DEBUG_TXT("Enables DEBUG mode"),
    CLI_FILE_TXT("File path to analyze"),
    CLI_OUTPUT_TXT("File path to write json"),
    CLI_POLICY_TXT("OPA policy/query path (internal to OPA server)"),
    CLI_HELP_TXT("Displays help, exits program"),
    CLI_JSON_TXT("Only outputs JSON from parsed class"),
    CLI_GRADLE_TXT("Parses Gradle file"),
    CLI_SCHEMA_TXT("Generate JSON schema, and write to provided path"),
    CLI_TYPE_TXT("Parses file of type specified"),
    CLI_WARN_TXT("Log warnings"),
    CLI_WASM_TXT("Enables OPA WASM Policy"),
    LABEL_ITEM_NOT_FOUND("<ITEM_NOT_FOUND>"),
    MSG_PROP_NOT_FOUND("Property not found"),
    MSG_ITEM_NOT_FOUND("Item not found"),
    MSG_DEBUG_FILE_PATH("DEBUG::File path: "),
    MSG_DEBUG_PARSER_TYPE("DEBUG::Parser type: "),
    MSG_DEBUG_POLICY_PATH("DEBUG::Policy path: "),
    MSG_DEBUG_PARSED_JSON("DEBUG::JSON: "),
    MSG_DEBUG_PARSED_MAP("DEBUG::MAP: "),
    MSG_DEBUG_OPA_RESULT("DEBUG::OPA result: "),
    MSG_FILE_NOT_SPECD("File path was not specified"),
    MSG_OUTPUT_POLICY_NOT_SPECD("Neither OPA policy or output path were specified"),
    MSG_PARSER_TYPE_NOT_SPECD("Parser type was not specified"),
    MSG_POLICY_NOT_SPECD("OPA policy path was not specified"),
    MSG_JAVA_VALID("Java is valid"),
    MSG_JAVA_INVALID("Java is invalid"),
    MSG_VALID(" is valid"),
    MSG_INVALID(" is invalid"),
    MSG_UNKNOWN_PARSER_TYPE("Supplied parser type is unknown"),
    MSG_DEBUG_JSON_SCHEMA("DEBUG::JSON schema: "),
    MSG_MALFORMED_CSV_FILE("CSV parser detected possible malformed file, at row %d. " +
            "Row field count (%d) does not equal file header count (%d). Data may be lost."),
    THROW_CLASS_PACKAGE_NOT_FOUND("true");

    private final String value;

    TextEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
