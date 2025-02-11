// Generated from ../java/input/Gradle.g4 by ANTLR 4.13.2
package compliance.parser.antlr.gradle.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GradleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GradleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GradleParser#buildFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuildFile(GradleParser.BuildFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GradleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#blockDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockDeclaration(GradleParser.BlockDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GradleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#parenthesesBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesBlock(GradleParser.ParenthesesBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(GradleParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(GradleParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#applyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyStatement(GradleParser.ApplyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#pluginStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPluginStatement(GradleParser.PluginStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#dependencyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependencyStatement(GradleParser.DependencyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#applicationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplicationStatement(GradleParser.ApplicationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#repositoriesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepositoriesStatement(GradleParser.RepositoriesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#tasksStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTasksStatement(GradleParser.TasksStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#tasksMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTasksMethod(GradleParser.TasksMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#tasksNamedMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTasksNamedMethod(GradleParser.TasksNamedMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#tasksRegisterMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTasksRegisterMethod(GradleParser.TasksRegisterMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#identifierMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierMethod(GradleParser.IdentifierMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#javaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJavaStatement(GradleParser.JavaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GradleParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(GradleParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#namedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgument(GradleParser.NamedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(GradleParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link GradleParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(GradleParser.OperatorContext ctx);
}