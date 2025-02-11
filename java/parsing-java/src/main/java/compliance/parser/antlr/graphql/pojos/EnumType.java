package compliance.parser.antlr.graphql.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnumType {
    private String name;
    private List<String> values = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "EnumType{" +
                "name='" + name + '\'' +
                ", values=" + values +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EnumType enumType = (EnumType) o;
        return Objects.equals(name, enumType.name) && Objects.equals(values, enumType.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, values);
    }
}
