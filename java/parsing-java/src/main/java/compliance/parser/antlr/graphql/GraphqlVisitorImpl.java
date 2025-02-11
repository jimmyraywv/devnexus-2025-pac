package compliance.parser.antlr.graphql;

import compliance.parser.antlr.graphql.gen.GraphQLBaseVisitor;
import compliance.parser.antlr.graphql.gen.GraphQLParser;
import compliance.parser.antlr.graphql.pojos.*;
import compliance.parser.antlr.graphql.pojos.EnumType;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class GraphqlVisitorImpl extends GraphQLBaseVisitor<String> {
    private static final Logger logger = LogManager.getLogger(GraphqlVisitorImpl.class);
    private final GraphqlConveyor conveyor = GraphqlConveyor.getInstance();
    private final Deque<StackLabels> stack = new ArrayDeque<>();
    private ObjectType objectType;
    private Field field;
    private Argument argument;
    private InputType inputType;
    private Directive directive;
    private EnumType enumm;
    //    private final List<Type> types = new ArrayList<>();
    private final List<Field> fields = new ArrayList<>();
    private final List<Argument> arguments = new ArrayList<>();
//    private final List<Input> inputs = new ArrayList<>();
//    private final List<Directive> directives = new ArrayList<>();
//    private final List<GraphqlEnum> enums = new ArrayList<>();

//    @Override
//    public String visitDocument(GraphQLParser.DocumentContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public String visitObjectTypeDefinition(GraphQLParser.ObjectTypeDefinitionContext ctx) {
////        this.type.setName(ctx.getChild(1).getText());
//        return visitChildren(ctx);
//    }

//    @Override
//    public String visitFieldDefinition(GraphQLParser.FieldDefinitionContext ctx) {
//        this.field = new Field();
//        if (this.stack.contains(StackLabels.TYPE)) {
//            this.type.getFields().add(this.field);
//        }
//        this.stack.push(StackLabels.FIELD);
//
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public String visitDirective(GraphQLParser.DirectiveContext ctx) {
//        this.directive = new Directive();
//        this.field.getDirectives().add(this.directive);
//        this.stack.push(StackLabels.DIRECTIVE);
//        return visitChildren(ctx);
//    }

//    @Override
//    public String visitEnumTypeDefinition(GraphQLParser.EnumTypeDefinitionContext ctx) {
//        this.stack.clear();
//        this.stack.push(StackLabels.ENUM);
//        this.enumm = new GraphqlEnum();
//        this.conveyor.getEnums().add(this.enumm);

    /// /        this.enums.add(this.enumm);
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public String visitInputObjectTypeDefinition(GraphQLParser.InputObjectTypeDefinitionContext ctx) {
//        this.stack.clear();
//        this.stack.push(StackLabels.INPUT);
//        this.input = new Input();
//        this.conveyor.getInputs().add(this.input);
//        return visitChildren(ctx);
//    }

    @Override
    public String visitName(GraphQLParser.NameContext ctx) {
        System.out.println("Peek: " + this.stack.peek());
        switch (this.stack.peek()) {
            case TYPE:
                System.out.println("Resolved Name: " + this.stack.peek());
                this.objectType.setName(ctx.getChild(1).getText());
                this.stack.pop();
                break;
//            case FIELD:
//                this.field.setName(ctx.getText());
//                this.stack.pop();
//                break;
//            case ARGUMENT:
//                this.argument.setName(ctx.getText());
//                this.stack.pop();
//                break;
//            case DIRECTIVE:
//                this.stack.pop();
//                this.directive.setName(ctx.getText());
//                break;
//            case INPUT:
//                this.input.setName(ctx.getText());
//                break;
//            case ENUM:
//                this.enumm.setName(ctx.getText());
//                break;
            default:
        }

        return visitChildren(ctx);
    }

//    @Override
//    public String visitDefinition(GraphQLParser.DefinitionContext ctx) {
//        System.out.println(new Object() {
//        }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }

//    @Override
//    public String visitExecutableDocument(GraphQLParser.ExecutableDocumentContext ctx) {
//        System.out.println(new Object() {
//        }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }
    @Override
    public String visitExecutableDefinition(GraphQLParser.ExecutableDefinitionContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitOperationDefinition(GraphQLParser.OperationDefinitionContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitOperationType(GraphQLParser.OperationTypeContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitSelectionSet(GraphQLParser.SelectionSetContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitSelection(GraphQLParser.SelectionContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitField(GraphQLParser.FieldContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitArguments(GraphQLParser.ArgumentsContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitArgument(GraphQLParser.ArgumentContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitAlias(GraphQLParser.AliasContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitFragmentSpread(GraphQLParser.FragmentSpreadContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitFragmentName(GraphQLParser.FragmentNameContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitTypeCondition(GraphQLParser.TypeConditionContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitInlineFragment(GraphQLParser.InlineFragmentContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitValue(GraphQLParser.ValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitIntValue(GraphQLParser.IntValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitFloatValue(GraphQLParser.FloatValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitBooleanValue(GraphQLParser.BooleanValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitStringValue(GraphQLParser.StringValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitNullValue(GraphQLParser.NullValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitEnumValue(GraphQLParser.EnumValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitListValue(GraphQLParser.ListValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitObjectValue(GraphQLParser.ObjectValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitObjectField(GraphQLParser.ObjectFieldContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitVariable(GraphQLParser.VariableContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitVariableDefinition(GraphQLParser.VariableDefinitionContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitDefaultValue(GraphQLParser.DefaultValueContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitType_(GraphQLParser.Type_Context ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitNamedType(GraphQLParser.NamedTypeContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public String visitListType(GraphQLParser.ListTypeContext ctx) {

        return visitChildren(ctx);
    }


    @Override
    public String visitDirectives(GraphQLParser.DirectivesContext ctx) {

        return visitChildren(ctx);
    }


//    @Override
//    public String visitTypeSystemDocument(GraphQLParser.TypeSystemDocumentContext ctx) {
//        System.out.println(new Object() {
//        }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitTypeSystemDefinition(GraphQLParser.TypeSystemDefinitionContext ctx) {
//        System.out.println(new Object() {
//        }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitTypeSystemExtensionDocument(GraphQLParser.TypeSystemExtensionDocumentContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitTypeSystemExtension(GraphQLParser.TypeSystemExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitSchemaDefinition(GraphQLParser.SchemaDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitRootOperationTypeDefinition(GraphQLParser.RootOperationTypeDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitSchemaExtension(GraphQLParser.SchemaExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitDescription(GraphQLParser.DescriptionContext ctx) {
//
//        return visitChildren(ctx);
//    }


    @Override
    public String visitTypeDefinition(GraphQLParser.TypeDefinitionContext ctx) {
        System.out.println("\n-------------------------------------------------\n" + new Object() {
        }.getClass().getEnclosingMethod().getName() + "::\n" + ctx.getText() + "\n\n");

        this.stack.clear();
        this.stack.push(StackLabels.TYPE);
        this.objectType = new ObjectType();
        this.conveyor.getObjectTypes().add(this.objectType);

//        System.out.println(visitChildren(ctx));
//
//        System.out.println(ctx.getText());

        this.drillDown(ctx);

//        int index = 0;
//        List<ParseTree> parseTrees = ctx.children;
//        for (ParseTree parseTree : parseTrees) {
//            System.out.println(index + "::Child::" + parseTree.getText());
//            System.out.println(index + "::Child-get-Child::" + parseTree.getChild(0).getText());
//            index++;
//        }

        return visitChildren(ctx);
    }

    private void drillDown(ParseTree parseTree) {
        System.out.println(parseTree.getText());
        ParseTree tree = parseTree.getChild(0);
        if (tree != null) this.drillDown(tree);

    }


//    @Override
//    public String visitTypeExtension(GraphQLParser.TypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitScalarTypeDefinition(GraphQLParser.ScalarTypeDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitScalarTypeExtension(GraphQLParser.ScalarTypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitImplementsInterfaces(GraphQLParser.ImplementsInterfacesContext ctx) {
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitFieldsDefinition(GraphQLParser.FieldsDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitArgumentsDefinition(GraphQLParser.ArgumentsDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitInputValueDefinition(GraphQLParser.InputValueDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitObjectTypeExtension(GraphQLParser.ObjectTypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitInterfaceTypeDefinition(GraphQLParser.InterfaceTypeDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitInterfaceTypeExtension(GraphQLParser.InterfaceTypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitUnionTypeDefinition(GraphQLParser.UnionTypeDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitUnionMemberTypes(GraphQLParser.UnionMemberTypesContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitUnionTypeExtension(GraphQLParser.UnionTypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitEnumValuesDefinition(GraphQLParser.EnumValuesDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitEnumValueDefinition(GraphQLParser.EnumValueDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitEnumTypeExtension(GraphQLParser.EnumTypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }

//    @Override
//    public String visitInputFieldsDefinition(GraphQLParser.InputFieldsDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitInputObjectTypeExtension(GraphQLParser.InputObjectTypeExtensionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitDirectiveDefinition(GraphQLParser.DirectiveDefinitionContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitDirectiveLocations(GraphQLParser.DirectiveLocationsContext ctx) {
//
//        return visitChildren(ctx);
//    }


//    @Override
//    public String visitDirectiveLocation(GraphQLParser.DirectiveLocationContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitExecutableDirectiveLocation(GraphQLParser.ExecutableDirectiveLocationContext ctx) {
//
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public String visitTypeSystemDirectiveLocation(GraphQLParser.TypeSystemDirectiveLocationContext ctx) {
//
//        return visitChildren(ctx);
//    }

}
