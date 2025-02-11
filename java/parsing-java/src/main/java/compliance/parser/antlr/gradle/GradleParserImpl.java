package compliance.parser.antlr.gradle;

import compliance.parser.antlr.gradle.gen.GradleLexer;
import compliance.parser.antlr.gradle.gen.GradleParser;
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
 * Parse implementation to configure ANTLR parser tree, listeners, and visitors
 *
 * @author jimmyray
 * @version 1.0
 */
public class GradleParserImpl {
    private static final Logger logger = LogManager.getLogger(GradleParserImpl.class);

    /**
     * Heavy lifting of parser setup/walking/listening/visiting
     *
     * @throws Exception Generic exception
     */
    public static void parse() throws Exception {
        GradleConveyor gc = GradleConveyor.getInstance();
        File file = new File(gc.getFilePath());
        String content = IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8);
        if (gc.isDebug()) {
            logger.debug("Gradle build file content (" + gc.getFilePath() + "):\n\n\n" + content);
        }

        // Start the parsing process - Content -> Lexer -> tokens -> Parser -> Tree
        GradleLexer gradleLexer = new GradleLexer(CharStreams.fromString(content));
        CommonTokenStream tokens = new CommonTokenStream(gradleLexer);
        GradleParser parser = new GradleParser(tokens);
        ParseTree tree = parser.buildFile(); // parse
//        walk(tree);
        GradleVisitorImpl visitor = new GradleVisitorImpl();
        visitor.visit(tree);

    }

    /**
     * Walk the parser tree, mainly needed for listeners
     *
     * @param tree ParserTree
     */
    static void walk(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        GradleListenerImpl listener = new GradleListenerImpl();
        walker.walk(listener, tree);

    }
}
