package compliance.parser.antlr.graphql;

import compliance.parser.antlr.graphql.gen.GraphQLLexer;
import compliance.parser.antlr.graphql.gen.GraphQLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Parse implementation to setup ANTLR parser tree, listeners, and visitors
 *
 * @author jimmyray
 * @version 1.0
 */
public class GraphqlParserImpl {
    private static final Logger logger = LogManager.getLogger(GraphqlParserImpl.class);

    /**
     * Heavy lifting of parser setup/walking/listening/visiting
     *
     * @throws Exception Generic exception
     */
    public static void parse() throws Exception {
        GraphqlConveyor conveyor = GraphqlConveyor.getInstance();
        File file = new File(conveyor.getFilePath());
        String content = IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8);
        if (conveyor.isDebug()) {
            logger.debug("GraphQL document content (" + conveyor.getFilePath() + "):\n\n\n" + content);
        }

        // Start the parsing process - Content -> Lexer -> tokens -> Parser -> Tree
        GraphQLLexer gradleLexer = new GraphQLLexer(CharStreams.fromString(content));
        CommonTokenStream tokens = new CommonTokenStream(gradleLexer);
        GraphQLParser parser = new GraphQLParser(tokens);
        ParseTree tree = parser.document();

        // Listener walk
//        walk(tree);

        GraphqlVisitorDebugger visitorDebugger = new GraphqlVisitorDebugger();
        visitorDebugger.visit(tree);

//        GraphqlVisitorImpl visitor = new GraphqlVisitorImpl();
//        visitor.visit(tree);
    }

    /**
     * Walk the parser tree, mainly needed for listeners
     *
     * @param tree ParserTree
     */
    static void walk(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        GraphqlListenerImpl listener = new GraphqlListenerImpl();
        walker.walk(listener, tree);

    }
}
