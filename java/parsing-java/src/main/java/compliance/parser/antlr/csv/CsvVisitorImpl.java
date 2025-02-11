package compliance.parser.antlr.csv;

import compliance.parser.antlr.csv.gen.CSVBaseVisitor;
import compliance.parser.antlr.csv.gen.CSVParser;
import compliance.parser.antlr.csv.pojos.Row;
import compliance.utils.Config;
import compliance.utils.TextEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class CsvVisitorImpl extends CSVBaseVisitor<String> {
    private static final Logger logger = LogManager.getLogger(CsvVisitorImpl.class);
    private final CsvConveyor conveyor = CsvConveyor.getInstance();
    private final Deque<String> stack = new ArrayDeque<>();
    private List<String> headers;
    private int rowCount;

    /**
     * Visits the first row of the file, and creates the headers collection which will be the JSON field names
     *
     * @param ctx from the parse tree position
     * @return default
     */
    @Override
    public String visitHdr(CSVParser.HdrContext ctx) {
        this.rowCount++;
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();

        this.headers = Arrays.stream(data.split(","))
                .map(String::trim).toList();

        this.stack.push(method);
        return visitChildren(ctx);
    }

    /**
     * Visits the row and parses the row into fields
     *
     * @param ctx from the parse tree position
     * @return default
     */
    @Override
    public String visitRow(CSVParser.RowContext ctx) {
        String lastMethod = this.stack.peek();
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();

        if (Objects.equals(lastMethod, "visitField")) {
            this.rowCount++;
            List<String> values = Arrays.stream(data.split(","))
                    .map(String::trim).toList();

            if (this.headers.size() != values.size())
                logger.warn((Config.properties.getProperty("msg.malformed.csv.file",
                        TextEnum.MSG_MALFORMED_CSV_FILE.getValue()))
                        .formatted(this.rowCount, values.size(), this.headers.size()));

            Row row = new Row();
            int index = 0;
            if (this.headers.size() > values.size()) {
                for (String value : values) {
                    row.getFields().put(this.headers.get(index), value);
                    index++;
                }
            } else {
                for (String header : this.headers) {
                    row.getFields().put(header, values.get(index));
                    index++;
                }
            }

            this.conveyor.getRows().add(row);
            this.stack.push(method);
        }

        return visitChildren(ctx);
    }

    /**
     * Method impl just needs to record the visit by pushing on to the stack
     *
     * @param ctx from the parse tree position
     * @return default
     */
    @Override
    public String visitField(CSVParser.FieldContext ctx) {
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();

        this.stack.push(method);
        return visitChildren(ctx);
    }
}
