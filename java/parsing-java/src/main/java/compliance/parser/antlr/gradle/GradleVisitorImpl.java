package compliance.parser.antlr.gradle;

import compliance.parser.antlr.gradle.gen.GradleBaseVisitor;
import compliance.parser.antlr.gradle.gen.GradleParser;
import compliance.utils.Strings;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of Gradle parser tree visitor
 *
 * @author jimmyray
 * @version 1.0
 */
public class GradleVisitorImpl extends GradleBaseVisitor<Object> {
    private static final Logger logger = LogManager.getLogger(GradleVisitorImpl.class);

    private GradleParser.BlockContext block;
    private List<GradleParser.StatementContext> blockContexts;
    private final GradleConveyor conveyor = GradleConveyor.getInstance();
    private final Map<String, GradlePlugin> plugins = new HashMap<>();
    private final Map<String, GradleBaseTasks> tasks = new HashMap<>();

    @Override
    public Object visitBuildFile(GradleParser.BuildFileContext ctx) {
        // Print entire build file, absent spaces and formatting
        if (conveyor.isDebug()) logger.debug(ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitStatement(GradleParser.StatementContext ctx) {
        // Print every statement, line by line
        if (conveyor.isDebug()) logger.debug(ctx.getText());
        return visitChildren(ctx);
    }

    /**
     * Handle group and version expression at root of Gradle build file
     *
     * @param ctx the parse tree
     * @return Object
     */
    @Override
    public Object visitExpression(GradleParser.ExpressionContext ctx) {
        ParserRuleContext parent = ctx.getParent();
        String value = parent.getText().replaceAll("\\s", "");
        if (value.contains("group=")) {
            conveyor.setGroup(Strings.getStringAfterString(value, "=").replaceAll("'", ""));
        } else if (value.contains("version=")) {
            conveyor.setVersion(Strings.getStringAfterString(value, "=").replaceAll("'", ""));
        }
        return visitChildren(ctx);
    }


    /**
     * Visits dependency statements and parses data
     *
     * @param ctx the parse tree
     * @return GradleConveyor singleton
     */
    @Override
    public Object visitDependencyStatement(GradleParser.DependencyStatementContext ctx) {
        this.block = ctx.block();
        this.blockContexts = this.block.statement();
        List<GradleDependency> dependencies = new ArrayList<>();

        if (!this.blockContexts.isEmpty()) {
            GradleDependency dependency = new GradleDependency();
            for (GradleParser.StatementContext blockContext : this.blockContexts) {
                if (!(blockContext.getText().contains(":") || blockContext.getText().contains("."))) {
                    if (conveyor.isWarn()) {
                        if (!GradleTasks.VALID_GRADLE_DEPENDENCY_CFG_TYPES.contains(blockContext.getText())) {
                            logger.warn("\"" + blockContext.getText() + "\" is not recognized as a valid dependency configuration type.");
                        }
                    }

                    // Get configuration type
                    dependency.setConfigurationType(blockContext.getText());
                } else if (blockContext.getText().replaceAll("\\s+", "").contains("files(")) {
                    // Handle files expression
                    dependency.setName("files");
                    String[] files = Strings.getStringBetweenStrings(blockContext.getText(), "(", ")").split(",");
                    if (files.length > 0) {
                        List<String> processedFiles = new ArrayList<>();
                        Arrays.stream(files).forEach(str -> processedFiles.add(str.replaceAll("'", "")));
                        dependency.setFiles(processedFiles);
                    }

                    dependencies.add(dependency);
                    dependency = new GradleDependency();
                } else if (blockContext.getText().replaceAll("\\s+", "").contains("fileTree(")) {
                    // Handle fileTree expression
                    dependency.setName("fileTree");
                    GradleDependencyFiletree filetree = new GradleDependencyFiletree();
                    // Collect arguments
                    String[] arguments = Strings.getStringBetweenStrings(blockContext.getText(), "(", ")")
                            .replaceAll("'", "").split(",");
                    if (arguments.length > 0) {
                        filetree.setArguments(Arrays.asList(arguments));
                    }

                    // Collect entries
                    String[] entries = Strings.getStringBetweenStrings(blockContext.getText(), "{", "}")
                            .split("\n");
                    if (entries.length > 0) {
                        filetree.setEntries(Arrays.asList(entries));
                    }

                    dependency.setFiletree(filetree);
                    dependencies.add(dependency);
                    dependency = new GradleDependency();
                } else {
                    // Handle dependency group/name/version elements
                    String[] words = Strings.trimSuffix(Strings.trimPrefix(blockContext.getText(), "'"), "'").split(":");

                    switch (words.length) {
                        case 1:
                            dependency.setName(words[0]);
                            break;
                        case 2:
                            dependency.setGroup(words[0]);
                            dependency.setName(words[1]);
                            break;
                        case 3:
                            dependency.setGroup(words[0]);
                            dependency.setName(words[1]);
                            dependency.setVersion(words[2]);
                            break;
                        default:
                    }

                    dependencies.add(dependency);
                    dependency = new GradleDependency();
                }

            }
        }

        this.conveyor.setDependencies(dependencies);

        return visitChildren(ctx);
    }

    /**
     * Visits plugin statements and parses data
     *
     * @param ctx the parse tree
     * @return GradleConveyor singleton
     */
    @Override
    public Object visitPluginStatement(GradleParser.PluginStatementContext ctx) {
        this.block = ctx.block();
        this.blockContexts = block.statement();

        if (!this.blockContexts.isEmpty()) {
            boolean nextVersion = false;
            String currentId = null;
            for (GradleParser.StatementContext blockContext : this.blockContexts) {
                String value = blockContext.getText().replaceAll("'", "");
                switch (value) {
                    case "id":
                        // noop
                        break;
                    case "version":
                        nextVersion = true;
                        break;
                    default:  //Handle content
                        if (nextVersion) {
                            this.plugins.get(currentId).setVersion(value);
                            nextVersion = false;
                            currentId = null;
                        } else {
                            currentId = value;
                            this.plugins.put(currentId, new GradlePlugin(currentId));
                        }
                }
            }
        }

        this.conveyor.setPlugins(new ArrayList<>(this.plugins.values()));

        return visitChildren(ctx);
    }

    /**
     * Visits application statements and parses data
     *
     * @param ctx the parse tree
     * @return GradleConveyor singleton
     */
    @Override
    public Object visitApplicationStatement(GradleParser.ApplicationStatementContext ctx) {
        this.block = ctx.block();
        this.blockContexts = this.block.statement();
        List<Map<String, String>> application = new ArrayList<>();

        if (!this.blockContexts.isEmpty()) {
            for (GradleParser.StatementContext blockContext : this.blockContexts) {
                Map<String, String> map = new HashMap<>();
                String[] pair = blockContext.getText().split("=");
                map.put("key", pair[0]);
                map.put("value", Strings.trimSuffix(Strings.trimPrefix(pair[1], "'"), "'"));
                application.add(map);
            }
        }

        this.conveyor.setApplication(application);

        return visitChildren(ctx);
    }

    /**
     * Visits repo statements and parses data
     *
     * @param ctx the parse tree
     * @return GradleConveyor singleton
     */
    @Override
    public Object visitRepositoriesStatement(GradleParser.RepositoriesStatementContext ctx) {
        this.block = ctx.block();
        this.blockContexts = this.block.statement();
        if (!this.blockContexts.isEmpty()) {
            List<String> repositories = new ArrayList<>();
            for (GradleParser.StatementContext blockContext : this.blockContexts) {
                repositories.add(blockContext.getText());
            }
            this.conveyor.setRepositories(repositories);
        }

        return visitChildren(ctx);
    }

    /**
     * Visits java statements and parses data
     *
     * @param ctx the parse tree
     * @return GradleConveyor singleton
     */
    @Override
    public Object visitJavaStatement(GradleParser.JavaStatementContext ctx) {
        this.block = ctx.block();
        this.blockContexts = this.block.statement();
        List<Map<String, String>> java = new ArrayList<>();
        if (!this.blockContexts.isEmpty()) {
            Map<String, String> map = new HashMap<>();
            for (GradleParser.StatementContext blockContext : this.blockContexts) {
                String[] keyValue = blockContext.getText().split("=");
                map.put(keyValue[0], Strings.getStringBetweenString(keyValue[1], "'"));
                java.add(map);
            }

            this.conveyor.setJava(java);
        }

        return visitChildren(ctx);
    }

    /**
     * Visits task statements and parses data
     *
     * @param ctx the parse tree
     * @return GradleConveyor singleton
     */
    @Override
    public Object visitTasksStatement(GradleParser.TasksStatementContext ctx) {
        this.block = ctx.block();
        this.blockContexts = this.block.statement();

        if (!this.blockContexts.isEmpty()) {
            for (GradleParser.StatementContext blockContext : this.blockContexts) {

                // Get parent task
                ParserRuleContext parent = blockContext.getParent().getParent();

                // Is this a named task?
                if (parent.getText().contains("tasks.named")) {
                    String value = Strings.getStringBetweenStrings(parent.getText(), "named('", "')");
                    if (!this.tasks.containsKey("named-" + value)) {
                        this.tasks.put("named-" + value, new GradleBaseTasks("named"));
                    }

                    this.processTaskContent(this.tasks.get("named-" + value), blockContext.getText(), Arrays.asList(value));
                }  // Is this a register task
                else if (parent.getText().contains("tasks.register")) {
                    String value = Strings.getStringBetweenStrings(parent.getText(), "register('", "'");
                    String label = Strings.getStringBetweenStrings(parent.getText(), "register('" + value + "',", ")");
                    if (!this.tasks.containsKey("register-" + value)) {
                        this.tasks.put("register-" + value, new GradleBaseTasks("register"));
                    }

                    this.processTaskContent(this.tasks.get("register-" + value), blockContext.getText(), Arrays.asList(value, label));
                } else {  //This is a lifecycle task
                    String value = Strings.getStringBetweenStrings(parent.getText(), "tasks.", "{");
                    if (!this.tasks.containsKey("lifecycle-" + value)) {
                        this.tasks.put("lifecycle-" + value, new GradleBaseTasks("lifecycle", value));
                    }
                    this.processTaskContent(this.tasks.get("lifecycle-" + value), blockContext.getText(), null);
                }
            }
        }

        this.conveyor.setTasks(new ArrayList<>(tasks.values()));
        return visitChildren(ctx);
    }

    /**
     * Helper method to process content
     *
     * @param task  Current task object in process
     * @param value Value to be parsed and added to task
     */
    private void processTaskContent(GradleBaseTasks task, String value, List<String> arguments) {
        if (value.contains("=")) {
            String[] keyValues = value.replaceAll("'", "").replaceAll("\"", "").split("=");
            task.addUniqueProperty(keyValues[0], keyValues[1]);
        } else {
            task.addUniqueItem(value);
        }

        if (arguments != null && !arguments.isEmpty()) {
            arguments.forEach(task::addUniqueArgument);
        }
    }
}
