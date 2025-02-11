package compliance.parser.antlr.gradle;

import java.util.ArrayList;
import java.util.List;

/**
 * Pojo for Gradle dependencies
 */
public class GradleDependency {

    private String configurationType;
    private String group;
    private String name;
    private String version;
    private List<String> files;
    private GradleDependencyFiletree filetree;

    public String getConfigurationType() {
        return configurationType;
    }

    public void setConfigurationType(String configurationType) {
        this.configurationType = configurationType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public GradleDependencyFiletree getFiletree() {
        return filetree;
    }

    public void setFiletree(GradleDependencyFiletree filetree) {
        this.filetree = filetree;
    }

    /**
     * Helper method to add a file
     *
     * @param file file
     */
    public void addFile(String file) {
        if (this.files == null) {
            this.files = new ArrayList<>();
        }
        this.files.add(file);
    }

    /**
     * Helper method to add a unique file
     *
     * @param file file
     */
    public void addUniqueFile(String file) {
        if (this.files == null) {
            this.files = new ArrayList<>();
        }

        if (!this.files.contains(file)) this.files.add(file);
    }

    @Override
    public String toString() {
        return "GradleDependency{" +
                "configurationType='" + configurationType + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", files=" + files +
                ", filetree=" + filetree +
                '}';
    }
}
