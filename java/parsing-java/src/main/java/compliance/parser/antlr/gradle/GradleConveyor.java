package compliance.parser.antlr.gradle;

import compliance.parser.ParserReturn;
import compliance.parser.antlr.Conveyor;
import compliance.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Singleton class to convey data to/from Gradle visitor implementations
 *
 * @author jimmyray
 * @version 1.0
 */
public class GradleConveyor implements Conveyor {

    private static GradleConveyor singletonInstance = null;
    private List<GradleDependency> dependencies = new ArrayList<>();
    private List<GradlePlugin> plugins = new ArrayList<>();
    private List<Map<String, String>> application = new ArrayList<>();
    private List<String> repositories = new ArrayList<>();
    private List<Map<String, String>> java = new ArrayList<>();
    private List<GradleTasks> tasks = new ArrayList<>();
    private String version;
    private String group;
    private boolean debug;
    private boolean warn;
    private String filePath;

    /**
     * Implements singleton pattern
     *
     * @return GradleConveyor singleton
     */
    public static synchronized GradleConveyor getInstance() {
        if (singletonInstance == null)
            singletonInstance = new GradleConveyor();

        return singletonInstance;
    }

    // Private constructor for singleton
    private GradleConveyor() {
    }

    public List<GradleDependency> getDependencies() {
        return this.dependencies;
    }

    public void setDependencies(List<GradleDependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<GradlePlugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<GradlePlugin> plugins) {
        this.plugins = plugins;
    }

    public List<Map<String, String>> getApplication() {
        return application;
    }

    public void setApplication(List<Map<String, String>> application) {
        this.application = application;
    }

    public List<String> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
    }

    public List<Map<String, String>> getJava() {
        return java;
    }

    public void setJava(List<Map<String, String>> java) {
        this.java = java;
    }

    public List<GradleTasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<GradleTasks> tasks) {
        this.tasks = tasks;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public boolean isWarn() {
        return warn;
    }

    public void setWarn(boolean warn) {
        this.warn = warn;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Parse JSON from Gradle pojos
     *
     * @return JSON as string
     * @throws Exception Generic exception
     */
    public ParserReturn getJson() throws Exception {
        ParsedGradle parsedGradle = new ParsedGradle();
        parsedGradle.setDependencies(this.dependencies);
        parsedGradle.setPlugins(this.plugins);
        parsedGradle.setApplication(this.application);
        parsedGradle.setRepositories(this.repositories);
        parsedGradle.setJava(this.java);
        parsedGradle.setTasks(this.tasks);
        parsedGradle.setGroup(this.group);
        parsedGradle.setVersion(this.version);

        return JsonUtils.getJson(parsedGradle);
    }

    /**
     * Generate JSON Schema
     *
     * @return String JSON schema
     */
    public String getSchema() {
        return JsonUtils.getSchema(ParsedGradle.class);
    }

    @Override
    public String toString() {
        return "GradleConveyor{" +
                "dependencies=" + dependencies +
                ", plugins=" + plugins +
                ", application=" + application +
                ", repositories=" + repositories +
                ", java=" + java +
                ", tasks=" + tasks +
                ", version='" + version + '\'' +
                ", group='" + group + '\'' +
                ", debug=" + debug +
                ", warn=" + warn +
                '}';
    }
}
