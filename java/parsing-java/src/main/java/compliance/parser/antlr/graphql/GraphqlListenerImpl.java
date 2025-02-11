package compliance.parser.antlr.graphql;

import compliance.parser.antlr.graphql.gen.GraphQLBaseListener;
import compliance.parser.antlr.graphql.gen.GraphQLParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class GraphqlListenerImpl extends GraphQLBaseListener {

    @Override
    public void enterDocument(GraphQLParser.DocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDocument(GraphQLParser.DocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDefinition(GraphQLParser.DefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDefinition(GraphQLParser.DefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterExecutableDocument(GraphQLParser.ExecutableDocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitExecutableDocument(GraphQLParser.ExecutableDocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterExecutableDefinition(GraphQLParser.ExecutableDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitExecutableDefinition(GraphQLParser.ExecutableDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterOperationDefinition(GraphQLParser.OperationDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitOperationDefinition(GraphQLParser.OperationDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterOperationType(GraphQLParser.OperationTypeContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitOperationType(GraphQLParser.OperationTypeContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterSelectionSet(GraphQLParser.SelectionSetContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitSelectionSet(GraphQLParser.SelectionSetContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterSelection(GraphQLParser.SelectionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitSelection(GraphQLParser.SelectionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterField(GraphQLParser.FieldContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitField(GraphQLParser.FieldContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterArguments(GraphQLParser.ArgumentsContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitArguments(GraphQLParser.ArgumentsContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterArgument(GraphQLParser.ArgumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitArgument(GraphQLParser.ArgumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterAlias(GraphQLParser.AliasContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitAlias(GraphQLParser.AliasContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterFragmentSpread(GraphQLParser.FragmentSpreadContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitFragmentSpread(GraphQLParser.FragmentSpreadContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterFragmentName(GraphQLParser.FragmentNameContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitFragmentName(GraphQLParser.FragmentNameContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeCondition(GraphQLParser.TypeConditionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeCondition(GraphQLParser.TypeConditionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInlineFragment(GraphQLParser.InlineFragmentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInlineFragment(GraphQLParser.InlineFragmentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterValue(GraphQLParser.ValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitValue(GraphQLParser.ValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterIntValue(GraphQLParser.IntValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitIntValue(GraphQLParser.IntValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterFloatValue(GraphQLParser.FloatValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitFloatValue(GraphQLParser.FloatValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterBooleanValue(GraphQLParser.BooleanValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitBooleanValue(GraphQLParser.BooleanValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterStringValue(GraphQLParser.StringValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitStringValue(GraphQLParser.StringValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterNullValue(GraphQLParser.NullValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitNullValue(GraphQLParser.NullValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterEnumValue(GraphQLParser.EnumValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitEnumValue(GraphQLParser.EnumValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterListValue(GraphQLParser.ListValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitListValue(GraphQLParser.ListValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterObjectValue(GraphQLParser.ObjectValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitObjectValue(GraphQLParser.ObjectValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterObjectField(GraphQLParser.ObjectFieldContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitObjectField(GraphQLParser.ObjectFieldContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterVariable(GraphQLParser.VariableContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitVariable(GraphQLParser.VariableContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterVariableDefinition(GraphQLParser.VariableDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitVariableDefinition(GraphQLParser.VariableDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDefaultValue(GraphQLParser.DefaultValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDefaultValue(GraphQLParser.DefaultValueContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterType_(GraphQLParser.Type_Context ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitType_(GraphQLParser.Type_Context ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterNamedType(GraphQLParser.NamedTypeContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitNamedType(GraphQLParser.NamedTypeContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterListType(GraphQLParser.ListTypeContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitListType(GraphQLParser.ListTypeContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDirectives(GraphQLParser.DirectivesContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDirectives(GraphQLParser.DirectivesContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDirective(GraphQLParser.DirectiveContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDirective(GraphQLParser.DirectiveContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeSystemDocument(GraphQLParser.TypeSystemDocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeSystemDocument(GraphQLParser.TypeSystemDocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeSystemDefinition(GraphQLParser.TypeSystemDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeSystemDefinition(GraphQLParser.TypeSystemDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeSystemExtensionDocument(GraphQLParser.TypeSystemExtensionDocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeSystemExtensionDocument(GraphQLParser.TypeSystemExtensionDocumentContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeSystemExtension(GraphQLParser.TypeSystemExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeSystemExtension(GraphQLParser.TypeSystemExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterSchemaDefinition(GraphQLParser.SchemaDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitSchemaDefinition(GraphQLParser.SchemaDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterRootOperationTypeDefinition(GraphQLParser.RootOperationTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitRootOperationTypeDefinition(GraphQLParser.RootOperationTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterSchemaExtension(GraphQLParser.SchemaExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitSchemaExtension(GraphQLParser.SchemaExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDescription(GraphQLParser.DescriptionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDescription(GraphQLParser.DescriptionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeDefinition(GraphQLParser.TypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeDefinition(GraphQLParser.TypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeExtension(GraphQLParser.TypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeExtension(GraphQLParser.TypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterScalarTypeDefinition(GraphQLParser.ScalarTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitScalarTypeDefinition(GraphQLParser.ScalarTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterScalarTypeExtension(GraphQLParser.ScalarTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitScalarTypeExtension(GraphQLParser.ScalarTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterObjectTypeDefinition(GraphQLParser.ObjectTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitObjectTypeDefinition(GraphQLParser.ObjectTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterImplementsInterfaces(GraphQLParser.ImplementsInterfacesContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitImplementsInterfaces(GraphQLParser.ImplementsInterfacesContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterFieldsDefinition(GraphQLParser.FieldsDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitFieldsDefinition(GraphQLParser.FieldsDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterFieldDefinition(GraphQLParser.FieldDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitFieldDefinition(GraphQLParser.FieldDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterArgumentsDefinition(GraphQLParser.ArgumentsDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitArgumentsDefinition(GraphQLParser.ArgumentsDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInputValueDefinition(GraphQLParser.InputValueDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInputValueDefinition(GraphQLParser.InputValueDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterObjectTypeExtension(GraphQLParser.ObjectTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitObjectTypeExtension(GraphQLParser.ObjectTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInterfaceTypeDefinition(GraphQLParser.InterfaceTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInterfaceTypeDefinition(GraphQLParser.InterfaceTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInterfaceTypeExtension(GraphQLParser.InterfaceTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInterfaceTypeExtension(GraphQLParser.InterfaceTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterUnionTypeDefinition(GraphQLParser.UnionTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitUnionTypeDefinition(GraphQLParser.UnionTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterUnionMemberTypes(GraphQLParser.UnionMemberTypesContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitUnionMemberTypes(GraphQLParser.UnionMemberTypesContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterUnionTypeExtension(GraphQLParser.UnionTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitUnionTypeExtension(GraphQLParser.UnionTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterEnumTypeDefinition(GraphQLParser.EnumTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitEnumTypeDefinition(GraphQLParser.EnumTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterEnumValuesDefinition(GraphQLParser.EnumValuesDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitEnumValuesDefinition(GraphQLParser.EnumValuesDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterEnumValueDefinition(GraphQLParser.EnumValueDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitEnumValueDefinition(GraphQLParser.EnumValueDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterEnumTypeExtension(GraphQLParser.EnumTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitEnumTypeExtension(GraphQLParser.EnumTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInputObjectTypeDefinition(GraphQLParser.InputObjectTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInputObjectTypeDefinition(GraphQLParser.InputObjectTypeDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInputFieldsDefinition(GraphQLParser.InputFieldsDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInputFieldsDefinition(GraphQLParser.InputFieldsDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterInputObjectTypeExtension(GraphQLParser.InputObjectTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitInputObjectTypeExtension(GraphQLParser.InputObjectTypeExtensionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDirectiveDefinition(GraphQLParser.DirectiveDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDirectiveDefinition(GraphQLParser.DirectiveDefinitionContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDirectiveLocations(GraphQLParser.DirectiveLocationsContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDirectiveLocations(GraphQLParser.DirectiveLocationsContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterDirectiveLocation(GraphQLParser.DirectiveLocationContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitDirectiveLocation(GraphQLParser.DirectiveLocationContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterExecutableDirectiveLocation(GraphQLParser.ExecutableDirectiveLocationContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitExecutableDirectiveLocation(GraphQLParser.ExecutableDirectiveLocationContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterTypeSystemDirectiveLocation(GraphQLParser.TypeSystemDirectiveLocationContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitTypeSystemDirectiveLocation(GraphQLParser.TypeSystemDirectiveLocationContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void enterName(GraphQLParser.NameContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitName(GraphQLParser.NameContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }


    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + node.getText() + "\n\n");
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        System.out.println("-------------------------------------------------\n" +
                new Object() {
                }.getClass().getEnclosingMethod().getName() + "::\n" + node.getText() + "\n\n");
    }
}
