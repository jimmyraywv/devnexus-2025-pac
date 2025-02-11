package compliance.parser.java;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Method
 *
 * @author jimmyray
 * @version 1.0
 *
 * POJO for Java class methods
 */

public class Method {

    // Constructor with builder as argument
    private Method(Builder builder) {
        this.methodName = builder.methodName;
        this.methodType = builder.methodtype;
        this.access = builder.access;
        this.annotations = builder.annotations;
        this.body = builder.body;
        this.properties = builder.properties;
    }

    private String methodName;
    private String methodType;
    private String access;
    private List<String> annotations;
    private String body;
    private Map<String, Boolean> properties;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String fieldName) {
        this.methodName = methodName;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String fieldType) {
        this.methodType = methodType;
    }

    public String getAccess() {
        return this.access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, Boolean> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Boolean> properties) {
        this.properties = properties;
    }

    // Static inner builder class
    public static class Builder {
        private String methodName;
        private String methodtype;
        private String access;
        private List<String> annotations;
        private String body;
        private Map<String, Boolean> properties;

        // Setters
        public Builder methodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder methodtype(String methodtype) {
            this.methodtype = methodtype;
            return this;
        }

        public Builder access(String access) {
            this.access = access;
            return this;
        }

        public Builder annotations(List<String> annotations) {
            this.annotations = annotations;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder properties(Map<String, Boolean> properties) {
            this.properties = properties;
            return this;
        }

        // Build method
        public Method build() {
            return new Method(this);
        }
    }

    @Override
    public String toString() {
        return "Method{" +
                "methodName='" + methodName + '\'' +
                ", methodType='" + methodType + '\'' +
                ", access='" + access + '\'' +
                ", annotations=" + annotations +
                ", body='" + body + '\'' +
                ", properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Method method = (Method) o;
        return Objects.equals(methodName, method.methodName) && Objects.equals(methodType, method.methodType) && Objects.equals(access, method.access) && Objects.equals(annotations, method.annotations) && Objects.equals(body, method.body) && Objects.equals(properties, method.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, methodType, access, annotations, body, properties);
    }
}
