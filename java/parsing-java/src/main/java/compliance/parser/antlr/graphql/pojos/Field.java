package compliance.parser.antlr.graphql.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Field {
    private String name;
    private List<Argument> arguments = new ArrayList<>();
    private List<Directive> directives = new ArrayList<>();
    private String suffix;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public List<Directive> getDirectives() {
        return directives;
    }

    public void setDirectives(List<Directive> directives) {
        this.directives = directives;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addUniqueDirective(Directive directive) {
        if (!this.directives.contains(directive)) {
            this.directives.add(directive);
        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", arguments=" + arguments +
                ", directives=" + directives +
                ", suffix='" + suffix + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(name, field.name) && Objects.equals(arguments, field.arguments) && Objects.equals(directives, field.directives) && Objects.equals(suffix, field.suffix) && Objects.equals(type, field.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, arguments, directives, suffix, type);
    }
}
