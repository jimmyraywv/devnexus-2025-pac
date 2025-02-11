package compliance.parser.antlr;

import compliance.parser.ParserReturn;

/**
 * Conveyor type is used to convey data to/from ANTLR parser visitors.
 * This type is implemented via singletons
 */
public interface Conveyor {

    void setDebug(boolean debug);

    boolean isDebug();

    void setWarn(boolean warn);

    boolean isWarn();

    void setFilePath(String filePath);

    String getFilePath();

    ParserReturn getJson() throws Exception;

    String getSchema();
}
