package compliance.parser.antlr.csv;

import compliance.parser.antlr.csv.pojos.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ParsedCsv pojo container for JSON processing
 */
public class ParsedCsv {

    private List<Row> rows = new ArrayList<>();

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ParsedCsv{" +
                "rows=" + rows +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParsedCsv parsedCsv = (ParsedCsv) o;
        return Objects.equals(rows, parsedCsv.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rows);
    }
}
