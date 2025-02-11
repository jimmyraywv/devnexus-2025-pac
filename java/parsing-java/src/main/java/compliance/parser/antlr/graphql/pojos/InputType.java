package compliance.parser.antlr.graphql.pojos;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InputType {
    private String name;
    Map<String, String> entries = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, String> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "InputType{" +
                "name='" + name + '\'' +
                ", entries=" + entries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InputType inputType = (InputType) o;
        return Objects.equals(name, inputType.name) && Objects.equals(entries, inputType.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, entries);
    }
}
