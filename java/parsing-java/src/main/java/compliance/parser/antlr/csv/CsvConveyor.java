package compliance.parser.antlr.csv;

import compliance.parser.ParserReturn;
import compliance.parser.antlr.Conveyor;
import compliance.parser.antlr.csv.pojos.Row;
import compliance.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to convey data to/from CSV visitor implementations
 *
 * @author jimmyray
 * @version 1.0
 */
public class CsvConveyor implements Conveyor {
    private boolean debug;
    private boolean warn;
    private String filePath;
    private List<Row> rows = new ArrayList<>();
    private static CsvConveyor singletonInstance = null;

    /**
     * Implements singleton pattern
     *
     * @return GraphqlConveyor singleton
     */
    public static synchronized CsvConveyor getInstance() {
        if (singletonInstance == null)
            singletonInstance = new CsvConveyor();

        return singletonInstance;
    }

    // Private constructor for singleton
    private CsvConveyor() {
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public boolean isWarn() {
        return warn;
    }

    public void setWarn(boolean warn) {
        this.warn = warn;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    /**
     * Parse JSON from GraphQL pojos
     *
     * @return JSON as string
     * @throws Exception General exception
     */
    public ParserReturn getJson() throws Exception {
        ParsedCsv parsedCsv = new ParsedCsv();
        parsedCsv.setRows(this.rows);

        return JsonUtils.getJson(parsedCsv);
    }

    /**
     * Generate JSON Schema
     *
     * @return String JSON schema
     */
    public String getSchema() {
        return JsonUtils.getSchema(ParsedCsv.class);
    }
}
