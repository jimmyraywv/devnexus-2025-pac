package compliance.parser.antlr.gradle;

/**
 * Pojo for Gradle plugins
 */
public class GradlePlugin {

    public GradlePlugin() {

    }

    public GradlePlugin(String id) {
        this.id = id;
    }

    private String id;
    private String version = "latest";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "GradlePlugin{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
