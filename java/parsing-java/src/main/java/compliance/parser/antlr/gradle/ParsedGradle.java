package compliance.parser.antlr.gradle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ParsedGradle pojo container for JSON processing
 *
 * @author jimmyray
 * @version 1.0
 */
public class ParsedGradle {

    private List<GradleDependency> dependencies = new ArrayList<>();
    private List<GradlePlugin> plugins = new ArrayList<>();
    private List<Map<String, String>> application = new ArrayList<>();
    private List<String> repositories = new ArrayList<>();
    private List<Map<String, String>> java = new ArrayList<>();
    private List<GradleTasks> tasks = new ArrayList<>();
    private String version;
    private String group;

    @JsonProperty(index = 20)
    public List<GradleDependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<GradleDependency> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty(index = 10)
    public List<GradlePlugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<GradlePlugin> plugins) {
        this.plugins = plugins;
    }

    @JsonProperty(index = 30)
    public List<Map<String, String>> getApplication() {
        return application;
    }

    public void setApplication(List<Map<String, String>> application) {
        this.application = application;
    }

    @JsonProperty(index = 40)
    public List<String> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
    }

    @JsonProperty(index = 50)
    public List<Map<String, String>> getJava() {
        return java;
    }

    public void setJava(List<Map<String, String>> java) {
        this.java = java;
    }

    @JsonProperty(index = 60)
    public List<GradleTasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<GradleTasks> tasks) {
        this.tasks = tasks;
    }

    @JsonProperty(index = 1)
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty(index = 2)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ParsedGradle{" +
                "dependencies=" + dependencies +
                ", plugins=" + plugins +
                ", application=" + application +
                ", repositories=" + repositories +
                ", java=" + java +
                ", tasks=" + tasks +
                ", version='" + version + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
