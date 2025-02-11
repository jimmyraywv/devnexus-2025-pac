package compliance.parser.antlr.graphql.pojos;

import java.util.Objects;

public class Argument {
    public String name;
    public String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Argument{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Argument argument = (Argument) o;
        return Objects.equals(name, argument.name) && Objects.equals(value, argument.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
