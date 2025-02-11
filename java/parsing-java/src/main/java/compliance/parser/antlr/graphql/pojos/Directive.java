package compliance.parser.antlr.graphql.pojos;

import java.util.Objects;

public class Directive {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Directive{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Directive directive = (Directive) o;
        return Objects.equals(text, directive.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
