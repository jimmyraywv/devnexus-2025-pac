// Generated from ../java/input/Gradle.g4 by ANTLR 4.13.2
package compliance.parser.antlr.gradle.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GradleParser}.
 */
public interface GradleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GradleParser#buildFile}.
	 * @param ctx the parse tree
	 */
	void enterBuildFile(GradleParser.BuildFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#buildFile}.
	 * @param ctx the parse tree
	 */
	void exitBuildFile(GradleParser.BuildFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GradleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GradleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#blockDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBlockDeclaration(GradleParser.BlockDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#blockDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBlockDeclaration(GradleParser.BlockDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GradleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GradleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#parenthesesBlock}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesBlock(GradleParser.ParenthesesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#parenthesesBlock}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesBlock(GradleParser.ParenthesesBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(GradleParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(GradleParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(GradleParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(GradleParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void enterApplyStatement(GradleParser.ApplyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#applyStatement}.
	 * @param ctx the parse tree
	 */
	void exitApplyStatement(GradleParser.ApplyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#pluginStatement}.
	 * @param ctx the parse tree
	 */
	void enterPluginStatement(GradleParser.PluginStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#pluginStatement}.
	 * @param ctx the parse tree
	 */
	void exitPluginStatement(GradleParser.PluginStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#dependencyStatement}.
	 * @param ctx the parse tree
	 */
	void enterDependencyStatement(GradleParser.DependencyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#dependencyStatement}.
	 * @param ctx the parse tree
	 */
	void exitDependencyStatement(GradleParser.DependencyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#applicationStatement}.
	 * @param ctx the parse tree
	 */
	void enterApplicationStatement(GradleParser.ApplicationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#applicationStatement}.
	 * @param ctx the parse tree
	 */
	void exitApplicationStatement(GradleParser.ApplicationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#repositoriesStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepositoriesStatement(GradleParser.RepositoriesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#repositoriesStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepositoriesStatement(GradleParser.RepositoriesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#tasksStatement}.
	 * @param ctx the parse tree
	 */
	void enterTasksStatement(GradleParser.TasksStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#tasksStatement}.
	 * @param ctx the parse tree
	 */
	void exitTasksStatement(GradleParser.TasksStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#tasksMethod}.
	 * @param ctx the parse tree
	 */
	void enterTasksMethod(GradleParser.TasksMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#tasksMethod}.
	 * @param ctx the parse tree
	 */
	void exitTasksMethod(GradleParser.TasksMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#tasksNamedMethod}.
	 * @param ctx the parse tree
	 */
	void enterTasksNamedMethod(GradleParser.TasksNamedMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#tasksNamedMethod}.
	 * @param ctx the parse tree
	 */
	void exitTasksNamedMethod(GradleParser.TasksNamedMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#tasksRegisterMethod}.
	 * @param ctx the parse tree
	 */
	void enterTasksRegisterMethod(GradleParser.TasksRegisterMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#tasksRegisterMethod}.
	 * @param ctx the parse tree
	 */
	void exitTasksRegisterMethod(GradleParser.TasksRegisterMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#identifierMethod}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierMethod(GradleParser.IdentifierMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#identifierMethod}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierMethod(GradleParser.IdentifierMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#javaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJavaStatement(GradleParser.JavaStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#javaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJavaStatement(GradleParser.JavaStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GradleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GradleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(GradleParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(GradleParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgument(GradleParser.NamedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#namedArgument}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgument(GradleParser.NamedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GradleParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GradleParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GradleParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(GradleParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GradleParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(GradleParser.OperatorContext ctx);
}