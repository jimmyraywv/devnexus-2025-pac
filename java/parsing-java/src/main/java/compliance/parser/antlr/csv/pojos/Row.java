package compliance.parser.antlr.csv.pojos;

import java.util.*;

public class Row {
    Map<String, String> fields = new LinkedHashMap<>();

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Row{" +
                "fields=" + fields +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(fields, row.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fields);
    }
}
