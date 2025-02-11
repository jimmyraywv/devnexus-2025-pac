package compliance.parser.antlr.graphql;

import compliance.parser.antlr.graphql.gen.GraphQLBaseVisitor;
import compliance.parser.antlr.graphql.gen.GraphQLParser;
import compliance.parser.antlr.graphql.pojos.*;
import compliance.utils.Strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class GraphqlVisitorDebugger extends GraphQLBaseVisitor<String> {
    private final GraphqlConveyor conveyor = GraphqlConveyor.getInstance();

//    Map<Integer, String> states = Map.of(
//            401, "scalarTypeDefinition",
//            402, "objectTypeDefinition",
//            403, "interfaceTypeDefinition",
//            404, "unionTypeDefinition",
//            405, "enumTypeDefinition",
//            406, "inputObjectTypeDefinition"
//    );

    private final Deque<String> stack = new ArrayDeque<>();
    private final Deque<StackLabels> labels = new ArrayDeque<>();
    private ObjectType objectType;
    private Field field;
    private InputType inputType;
    private EnumType enumType;

    @Override
    public String visitDocument(GraphQLParser.DocumentContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        this.labels.push(StackLabels.START);
        return visitChildren(ctx);
    }

//    @Override
//    public String visitDefinition(GraphQLParser.DefinitionContext ctx) {
//        String method = new Object() {
//        }.getClass().getEnclosingMethod().getName();
//        this.stack.push(method);
//        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public String visitExecutableDocument(GraphQLParser.ExecutableDocumentContext ctx) {
//        String method = new Object() {
//        }.getClass().getEnclosingMethod().getName();
//        this.stack.push(method);
//        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }

    @Override
    public String visitExecutableDefinition(GraphQLParser.ExecutableDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitOperationDefinition(GraphQLParser.OperationDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitOperationType(GraphQLParser.OperationTypeContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitSelectionSet(GraphQLParser.SelectionSetContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitSelection(GraphQLParser.SelectionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitField(GraphQLParser.FieldContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitArguments(GraphQLParser.ArgumentsContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitArgument(GraphQLParser.ArgumentContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitAlias(GraphQLParser.AliasContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitFragmentSpread(GraphQLParser.FragmentSpreadContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitFragmentName(GraphQLParser.FragmentNameContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitTypeCondition(GraphQLParser.TypeConditionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitInlineFragment(GraphQLParser.InlineFragmentContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitValue(GraphQLParser.ValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitIntValue(GraphQLParser.IntValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitFloatValue(GraphQLParser.FloatValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitBooleanValue(GraphQLParser.BooleanValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitStringValue(GraphQLParser.StringValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitNullValue(GraphQLParser.NullValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitEnumValue(GraphQLParser.EnumValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitListValue(GraphQLParser.ListValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitObjectValue(GraphQLParser.ObjectValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitObjectField(GraphQLParser.ObjectFieldContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitVariable(GraphQLParser.VariableContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitVariableDefinition(GraphQLParser.VariableDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDefaultValue(GraphQLParser.DefaultValueContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitType_(GraphQLParser.Type_Context ctx) {
        String lastMethod = this.stack.peek();
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        System.out.println("LAST_METHOD: " + lastMethod);


        if (lastMethod != null && lastMethod.equals("visitName")) {
            this.field.setType(data);
        }

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitNamedType(GraphQLParser.NamedTypeContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitListType(GraphQLParser.ListTypeContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDirectives(GraphQLParser.DirectivesContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDirective(GraphQLParser.DirectiveContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        Directive directive = new Directive();
        directive.setText(data);

        this.field.addUniqueDirective(directive);

        this.stack.push(method);
        return visitChildren(ctx);
    }

//    @Override
//    public String visitTypeSystemDocument(GraphQLParser.TypeSystemDocumentContext ctx) {
//        String method = new Object() {
//        }.getClass().getEnclosingMethod().getName();
//        this.stack.push(method);
//        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }

//    @Override
//    public String visitTypeSystemDefinition(GraphQLParser.TypeSystemDefinitionContext ctx) {
//        String method = new Object() {
//        }.getClass().getEnclosingMethod().getName();
//        this.stack.push(method);
//        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }

    @Override
    public String visitTypeSystemExtensionDocument(GraphQLParser.TypeSystemExtensionDocumentContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitTypeSystemExtension(GraphQLParser.TypeSystemExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitSchemaDefinition(GraphQLParser.SchemaDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitRootOperationTypeDefinition(GraphQLParser.RootOperationTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitSchemaExtension(GraphQLParser.SchemaExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDescription(GraphQLParser.DescriptionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

//    @Override
//    public String visitTypeDefinition(GraphQLParser.TypeDefinitionContext ctx) {
//        String method = new Object() {
//        }.getClass().getEnclosingMethod().getName();
//        this.stack.push(method);
//        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + ctx.getText() + "\n\n");
//        return visitChildren(ctx);
//    }

    @Override
    public String visitTypeExtension(GraphQLParser.TypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitScalarTypeDefinition(GraphQLParser.ScalarTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitScalarTypeExtension(GraphQLParser.ScalarTypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitObjectTypeDefinition(GraphQLParser.ObjectTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        this.objectType = new ObjectType();
        this.conveyor.getObjectTypes().add(objectType);
        return visitChildren(ctx);
    }

    @Override
    public String visitImplementsInterfaces(GraphQLParser.ImplementsInterfacesContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitFieldsDefinition(GraphQLParser.FieldsDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitFieldDefinition(GraphQLParser.FieldDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        this.field = new Field();
        this.labels.push(StackLabels.FIELD);
        String suffix = Strings.getStringBetweenStrings(data, "):", "@");
        if (suffix != null && !suffix.contains(":")) this.field.setSuffix(suffix);
        this.objectType.getFields().add(this.field);

        return visitChildren(ctx);
    }

    @Override
    public String visitArgumentsDefinition(GraphQLParser.ArgumentsDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        this.labels.push(StackLabels.TYPE);
        return visitChildren(ctx);
    }

    @Override
    public String visitInputValueDefinition(GraphQLParser.InputValueDefinitionContext ctx) {
        String lastMethod = this.stack.peek();
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        System.out.println("LAST_METHOD: " + lastMethod);
        String[] keyValue = data.split(":");
        System.out.println("Data keyValue length: " + keyValue.length);
        switch (Strings.nullValue(lastMethod, "")) {
            case "visitArgumentsDefinition":
                if (keyValue.length >= 2) {
                    System.out.println("Arg name: " + keyValue[0]);
                    System.out.println("Arg value: " + keyValue[1]);
                    Argument argument = new Argument();
                    argument.setName(keyValue[0]);
                    argument.setValue(keyValue[1]);
                    System.out.println("Argument: " + argument);
                    this.field.getArguments().add(argument);
                    System.out.println("FIELD Args count: " + this.field.getArguments().size());
                    System.out.println("FIELD: " + this.field);
                }
                break;
            case "visitName":
                switch (Objects.requireNonNull(this.labels.peek())) {
                    case FIELD:
                        if (keyValue.length >= 2) {
                            Argument argument = new Argument();
                            argument.setName(keyValue[0]);
                            argument.setValue(keyValue[1]);
                            System.out.println("Argument: " + argument);
                            this.field.getArguments().add(argument);
                            System.out.println("Arg name: " + keyValue[0]);
                            System.out.println("Arg value: " + keyValue[1]);
                        }
                        break;
                    case INPUT:
                        if (keyValue.length >= 2) {
                            System.out.println("Input key: " + keyValue[0]);
                            System.out.println("Input value: " + keyValue[1]);
                            this.inputType.getEntries().put(keyValue[0], keyValue[1]);
                        }
                        break;
                }
                break;
            case "visitInputFieldsDefinition":
                if (keyValue.length >= 2) {
                    System.out.println("Input key: " + keyValue[0]);
                    System.out.println("Input value: " + keyValue[1]);
                    this.inputType.getEntries().put(keyValue[0], keyValue[1]);
                }
                break;
            default:
        }

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitObjectTypeExtension(GraphQLParser.ObjectTypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitInterfaceTypeDefinition(GraphQLParser.InterfaceTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitInterfaceTypeExtension(GraphQLParser.InterfaceTypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitUnionTypeDefinition(GraphQLParser.UnionTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitUnionMemberTypes(GraphQLParser.UnionMemberTypesContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitUnionTypeExtension(GraphQLParser.UnionTypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitEnumTypeDefinition(GraphQLParser.EnumTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        this.enumType = new EnumType();
        this.conveyor.getEnumTypes().add(this.enumType);
        this.labels.push(StackLabels.ENUM);

        return visitChildren(ctx);
    }

    @Override
    public String visitEnumValuesDefinition(GraphQLParser.EnumValuesDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitEnumValueDefinition(GraphQLParser.EnumValueDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.enumType.getValues().add(data);

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitEnumTypeExtension(GraphQLParser.EnumTypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitInputObjectTypeDefinition(GraphQLParser.InputObjectTypeDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        this.inputType = new InputType();
        this.conveyor.getInputTypes().add(this.inputType);
        this.labels.push(StackLabels.INPUT);

        return visitChildren(ctx);
    }

    @Override
    public String visitInputFieldsDefinition(GraphQLParser.InputFieldsDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitInputObjectTypeExtension(GraphQLParser.InputObjectTypeExtensionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDirectiveDefinition(GraphQLParser.DirectiveDefinitionContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDirectiveLocations(GraphQLParser.DirectiveLocationsContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitDirectiveLocation(GraphQLParser.DirectiveLocationContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitExecutableDirectiveLocation(GraphQLParser.ExecutableDirectiveLocationContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitTypeSystemDirectiveLocation(GraphQLParser.TypeSystemDirectiveLocationContext ctx) {
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        this.stack.push(method);
        return visitChildren(ctx);
    }

    @Override
    public String visitName(GraphQLParser.NameContext ctx) {
        String lastMethod = this.stack.peek();
        String data = ctx.getText();
        String method = new Object() {
        }.getClass().getEnclosingMethod().getName();
        System.out.println("\n-------------------------------------------------\n" + method + "::\n" + data + "\n\n");

        System.out.println("LAST_METHOD::" + lastMethod);

        switch (Strings.nullValue(lastMethod, "")) {
            case "visitObjectTypeDefinition":
                this.objectType.setName(data);
                break;
            case "visitFieldDefinition":
                this.field.setName(data);
                break;
            case "visitInputObjectTypeDefinition":
                this.inputType.setName(data);
                break;
//            case "visitInputValueDefinition":
//                this.inputType.setName(data);
//                break;
            case "visitEnumTypeDefinition":
                this.enumType.setName(data);
                break;
            default:
        }

        this.stack.push(method);
        return visitChildren(ctx);
    }
}
