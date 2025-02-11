package compliance.parser.java;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Field
 *
 * @author jimmyray
 * @version 1.0
 *
 * POJO for Java class fields
 */
public class Field {

    // Constructor with builder as argument
    private Field(Builder builder) {
        this.fieldName = builder.fieldName;
        this.fieldType = builder.fieldType;
        this.access = builder.access;
        this.annotations = builder.annotations;
        this.properties = builder.properties;
    }

    private String fieldName;
    private String fieldType;
    private String access;
    private List<String> annotations;
    private Map<String, Boolean> properties;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getAccess() {
        return access;
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

    public Map<String, Boolean> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Boolean> properties) {
        this.properties = properties;
    }

    // Static inner builder class
    public static class Builder {
        private String fieldName;
        private String fieldType;
        private String access;
        private List<String> annotations;
        private Map<String, Boolean> properties;

        // Setters
        public Builder fieldName(String fieldName) {
            this.fieldName = fieldName;
            return this;
        }

        public Builder fieldType(String fieldType) {
            this.fieldType = fieldType;
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

        public Builder properties(Map<String, Boolean> properties) {
            this.properties = properties;
            return this;
        }

        // Build method
        public Field build() {
            return new Field(this);
        }
    }

    @Override
    public String toString() {
        return "Field{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", access='" + access + '\'' +
                ", annotations=" + annotations +
                ", properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(fieldName, field.fieldName) && Objects.equals(fieldType, field.fieldType) && Objects.equals(access, field.access) && Objects.equals(annotations, field.annotations) && Objects.equals(properties, field.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, fieldType, access, annotations, properties);
    }
}
