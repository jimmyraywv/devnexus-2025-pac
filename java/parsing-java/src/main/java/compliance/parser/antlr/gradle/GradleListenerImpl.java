// Generated from ../java/input/Gradle.g4 by ANTLR 4.13.2
package compliance.parser.antlr.gradle;

import compliance.parser.antlr.gradle.gen.GradleBaseListener;
import compliance.parser.antlr.gradle.gen.GradleParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Implementation of Gradle parser tree listener
 *
 * @author jimmyray
 * @version 1.0
 */
public class GradleListenerImpl extends GradleBaseListener {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBuildFile(GradleParser.BuildFileContext ctx) {
        System.out.println("First line: " + ctx.start.getLine());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBuildFile(GradleParser.BuildFileContext ctx) {
        System.out.println("Last line: " + ctx.stop.getLine());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStatement(GradleParser.StatementContext ctx) {
        System.out.println("Statement: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStatement(GradleParser.StatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlockDeclaration(GradleParser.BlockDeclarationContext ctx) {
        System.out.println("Block: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlockDeclaration(GradleParser.BlockDeclarationContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlock(GradleParser.BlockContext ctx) {
        System.out.println("Block: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlock(GradleParser.BlockContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterParenthesesBlock(GradleParser.ParenthesesBlockContext ctx) {
        System.out.println("Parens Block: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitParenthesesBlock(GradleParser.ParenthesesBlockContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignmentStatement(GradleParser.AssignmentStatementContext ctx) {
        System.out.println("Assignment statement: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignmentStatement(GradleParser.AssignmentStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMethodCall(GradleParser.MethodCallContext ctx) {
        System.out.println("MethodCall: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMethodCall(GradleParser.MethodCallContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterApplyStatement(GradleParser.ApplyStatementContext ctx) {
        System.out.println("ApplyStatement: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitApplyStatement(GradleParser.ApplyStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPluginStatement(GradleParser.PluginStatementContext ctx) {
        System.out.println("PluginStatement: " + ctx.getText());

        String[] plugins = ctx.getText().split("id");
        for (String plugin : plugins) {
            System.out.println("Plugin: " + plugin);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPluginStatement(GradleParser.PluginStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDependencyStatement(GradleParser.DependencyStatementContext ctx) {
        System.out.println("Dependency: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDependencyStatement(GradleParser.DependencyStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExpression(GradleParser.ExpressionContext ctx) {
        System.out.println("Expression: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExpression(GradleParser.ExpressionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArgument(GradleParser.ArgumentContext ctx) {
        System.out.println("Argument: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArgument(GradleParser.ArgumentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNamedArgument(GradleParser.NamedArgumentContext ctx) {
        System.out.println("NamedArgument: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNamedArgument(GradleParser.NamedArgumentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLiteral(GradleParser.LiteralContext ctx) {
        System.out.println("Literal: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLiteral(GradleParser.LiteralContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterOperator(GradleParser.OperatorContext ctx) {
        System.out.println("Operator: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitOperator(GradleParser.OperatorContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("EveryRule: " + ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
    }
}