package compliance.parser.java;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * ParsedClass
 *
 * @author jimmyray
 * @version 1.0
 *
 * POJO for parsed Java class
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ParsedClass {

    private String className;
    private String packageName;
    private String source;
    private String access;
    private List<String> annotations;
    private List<Method> methods;
    private List<Field> fields;
    private List<String> imports;

    @JsonProperty(index = 10)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty(index = 11)
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @JsonProperty(index = 70)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty(index = 20)
    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty(index = 15)
    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty(index = 60)
    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    @JsonProperty(index = 50)
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @JsonProperty(index = 30)
    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    @Override
    public String toString() {
        return "ParsedClass{" +
                "className='" + className + '\'' +
                ", packageName='" + packageName + '\'' +
                ", source='" + source + '\'' +
                ", access='" + access + '\'' +
                ", annotations=" + annotations +
                ", methods=" + methods +
                ", fields=" + fields +
                ", imports=" + imports +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParsedClass that = (ParsedClass) o;
        return Objects.equals(className, that.className) && Objects.equals(packageName, that.packageName) && Objects.equals(source, that.source) && Objects.equals(access, that.access) && Objects.equals(annotations, that.annotations) && Objects.equals(methods, that.methods) && Objects.equals(fields, that.fields) && Objects.equals(imports, that.imports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, packageName, source, access, annotations, methods, fields, imports);
    }
}
