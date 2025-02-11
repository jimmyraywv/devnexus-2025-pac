package compliance.parser.antlr.graphql;

/**
 * Used to keep track of types being parsed/visited
 */
public enum StackLabels {
    START,
    TYPE,
    FIELD,
    DIRECTIVE,
    ARGUMENT,
    ENUM,
    INPUT,
    END
}
