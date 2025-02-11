package compliance.parser.java;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import compliance.parser.ParserReturn;
import compliance.utils.JsonUtils;
import compliance.utils.TextEnum;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * ClassParser uses JavaParser
 *
 * @author jimmyray
 * @version 1.0
 */
public class ClassParser {

    /**
     * Parse the class
     *
     * @param filePath to the parsed file
     * @return ParserReturn
     * @throws Exception Covers all exceptions
     */
    public static ParserReturn parse(String filePath) throws Exception {
        // Parse the Java file
        CompilationUnit cu = StaticJavaParser.parse(new File(filePath));
        ParsedClass parsedClass = new ParsedClass();
        parsedClass.setClassName(cu.getType(0).getNameAsString());

        // Class package
        var packageDeclaration = cu.getPackageDeclaration();
        packageDeclaration.ifPresentOrElse(pd -> parsedClass.setPackageName(pd.getNameAsString()),
                () -> parsedClass.setPackageName(""));

        // Class access
        parsedClass.setAccess(cu.getType(0).getAccessSpecifier().toString());

        // Get the source code for the class
//        parsedClass.setSource(cu.toString());

        // Class imports
        List<String> imports = new ArrayList<>();
        for (ImportDeclaration importDeclaration : cu.getImports()) imports.add(importDeclaration.getNameAsString());
        parsedClass.setImports(imports);

        // Class annotations
        List<String> annotations = new ArrayList<>();
        cu.getType(0).getAnnotations().forEach(a -> annotations.add(a.toString()));
        parsedClass.setAnnotations(annotations);

        // Methods
        List<Method> methods = new ArrayList<>();
        for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
            List<String> fa = new ArrayList<>();

            for (AnnotationExpr ae : method.asMethodDeclaration().getAnnotations()) {
                fa.add(ae.toString());
            }

            Map<String, Boolean> properties = new HashMap<>();
            properties.put(TextEnum.STATIC.getValue(), method.isStatic());
            properties.put(TextEnum.ABSTRACT.getValue(), method.isAbstract());
            properties.put(TextEnum.FINAL.getValue(), method.isFinal());
            properties.put(TextEnum.PROTECTED.getValue(), method.isProtected());

            methods.add(new Method.Builder().methodName(method.getNameAsString()).methodtype(method.getTypeAsString())
                    .access(method.getAccessSpecifier().toString()).annotations(fa).body(method.getBody().toString())
                    .properties(properties).build());
        }
        parsedClass.setMethods(methods);

        // Fields
        List<Field> fields = new ArrayList<>();
        for (FieldDeclaration field : cu.findAll(FieldDeclaration.class)) {
            List<String> fa = new ArrayList<>();

            for (AnnotationExpr ae : field.asFieldDeclaration().getAnnotations()) {
                fa.add(ae.toString());
            }

            Map<String, Boolean> properties = new HashMap<>();
            properties.put(TextEnum.STATIC.getValue(), field.isStatic());
            properties.put(TextEnum.FINAL.getValue(), field.isFinal());
            properties.put(TextEnum.PROTECTED.getValue(), field.isProtected());
            properties.put(TextEnum.TRANSIENT.getValue(), field.isTransient());
            properties.put(TextEnum.VOLATILE.getValue(), field.isVolatile());

            fields.add(new Field.Builder().fieldName(field.getVariable(0).getNameAsString()).fieldType(
                            field.getCommonType().toString()).access(field.getAccessSpecifier().toString()).properties(properties)
                    .annotations(fa).build());
        }

        parsedClass.setFields(fields);

        // JSON output
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        String json = mapper.writeValueAsString(parsedClass);
        Map<String, Object> map = mapper.convertValue(parsedClass, new TypeReference<>() {});
        return new ParserReturn(map, json);
    }

    /**
     * Generate JSON Schema
     *
     * @return String JSON schema
     */
    public static String getSchema() {
        return JsonUtils.getSchema(ParsedClass.class);
    }
}
