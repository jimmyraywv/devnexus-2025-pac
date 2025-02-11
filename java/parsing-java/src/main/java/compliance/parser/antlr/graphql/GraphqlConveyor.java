package compliance.parser.antlr.graphql;

import compliance.parser.ParserReturn;
import compliance.parser.antlr.Conveyor;
import compliance.parser.antlr.graphql.pojos.EnumType;
import compliance.parser.antlr.graphql.pojos.InputType;
import compliance.parser.antlr.graphql.pojos.ObjectType;
import compliance.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to convey data to/from GraphQL visitor implementations
 *
 * @author jimmyray
 * @version 1.0
 */
public class GraphqlConveyor implements Conveyor {
    private boolean debug;
    private boolean warn;
    private String filePath;
    private static GraphqlConveyor singletonInstance = null;
    private List<ObjectType> objectTypes = new ArrayList<>();
    private List<EnumType> enumTypes = new ArrayList<>();
    private List<InputType> inputTypes = new ArrayList<>();

    /**
     * Implements singleton pattern
     *
     * @return GraphqlConveyor singleton
     */
    public static synchronized GraphqlConveyor getInstance() {
        if (singletonInstance == null)
            singletonInstance = new GraphqlConveyor();

        return singletonInstance;
    }

    // Private constructor for singleton
    private GraphqlConveyor() {
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

    public List<ObjectType> getObjectTypes() {
        return objectTypes;
    }

    public void setObjectTypes(List<ObjectType> objectTypes) {
        this.objectTypes = objectTypes;
    }

    public List<EnumType> getEnumTypes() {
        return enumTypes;
    }

    public void setEnums(List<EnumType> enumTypes) {
        this.enumTypes = enumTypes;
    }

    public List<InputType> getInputTypes() {
        return inputTypes;
    }

    public void setInputTypes(List<InputType> inputTypes) {
        this.inputTypes = inputTypes;
    }

    /**
     * Parse JSON from GraphQL pojos
     *
     * @return JSON as string
     * @throws Exception General exception
     */
    public ParserReturn getJson() throws Exception {
        ParsedGraphql parsedGraphql = new ParsedGraphql();
        parsedGraphql.setObjectTypes(this.objectTypes);
        parsedGraphql.setEnumTypes(this.enumTypes);
        parsedGraphql.setInputTypes(this.inputTypes);

        return JsonUtils.getJson(parsedGraphql);
    }

    /**
     * Generate JSON Schema
     *
     * @return String JSON schema
     */
    public String getSchema() {
        return JsonUtils.getSchema(ParsedGraphql.class);
    }

    @Override
    public String toString() {
        return "GraphqlConveyor{" +
                "debug=" + debug +
                ", warn=" + warn +
                ", filePath='" + filePath + '\'' +
                ", objectTypes=" + objectTypes +
                ", enumTypes=" + enumTypes +
                ", inputTypes=" + inputTypes +
                '}';
    }
}

