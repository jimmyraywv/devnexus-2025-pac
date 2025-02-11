package compliance.parser.antlr.graphql;

import compliance.parser.antlr.graphql.pojos.EnumType;
import compliance.parser.antlr.graphql.pojos.InputType;
import compliance.parser.antlr.graphql.pojos.ObjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ParsedGraphQL pojo container for JSON processing
 */
public class ParsedGraphql {
    private List<ObjectType> objectTypes = new ArrayList<>();
    private List<EnumType> enumTypes = new ArrayList<>();
    private List<InputType> inputTypes = new ArrayList<>();

    public List<ObjectType> getObjectTypes() {
        return objectTypes;
    }

    public void setObjectTypes(List<ObjectType> objectTypes) {
        this.objectTypes = objectTypes;
    }

    public List<EnumType> getEnumTypes() {
        return enumTypes;
    }

    public void setEnumTypes(List<EnumType> enumTypes) {
        this.enumTypes = enumTypes;
    }

    public List<InputType> getInputTypes() {
        return inputTypes;
    }

    public void setInputTypes(List<InputType> inputTypes) {
        this.inputTypes = inputTypes;
    }

    @Override
    public String toString() {
        return "ParsedGraphql{" +
                "objectTypes=" + objectTypes +
                ", enumTypes=" + enumTypes +
                ", inputTypes=" + inputTypes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParsedGraphql that = (ParsedGraphql) o;
        return Objects.equals(objectTypes, that.objectTypes) && Objects.equals(enumTypes, that.enumTypes) && Objects.equals(inputTypes, that.inputTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectTypes, enumTypes, inputTypes);
    }
}
