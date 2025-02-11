package compliance.parser.antlr.gradle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradleBaseTasks implements GradleTasks {
    protected String type;
    protected String name;
    protected List<String> arguments;
    protected List<String> items;
    protected Map<String, String> properties;

    public GradleBaseTasks(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public GradleBaseTasks(String type) {
        this.type = type;
    }

    public GradleBaseTasks() {
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setNameId(String name) {
        this.name = name;
    }

    @Override
    public List<String> getArguments() {
        if (this.arguments == null) {
            this.arguments = new ArrayList<>();
        }
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public List<String> getItems() {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public Map<String, String> getProperties() {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        return properties;
    }

    public void setParams(Map<String, String> properties) {
        this.properties = properties;
    }

    /**
     * Helper method to add an argument
     *
     * @param argument value to be added to arguments list
     */
    public void addArgument(String argument) {
        if (this.arguments == null) {
            this.arguments = new ArrayList<>();
        }
        this.arguments.add(argument);
    }

    /**
     * Helper method to add an unique argument
     *
     * @param argument value to be added to arguments list
     */
    public void addUniqueArgument(String argument) {
        if (this.arguments == null) {
            this.arguments = new ArrayList<>();
        }

        if (!this.arguments.contains(argument)) this.arguments.add(argument);
    }

    /**
     * Helper method to add an item
     *
     * @param item value to be added to items list
     */
    public void addItem(String item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    /**
     * Helper method to add a unique item
     *
     * @param item value to be added to items list
     */
    public void addUniqueItem(String item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        if (!this.items.contains(item)) this.items.add(item);
    }

    /**
     * Helper method to add a param
     *
     * @param key   param key
     * @param value param value
     */
    public void addProperty(String key, String value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, value);
    }

    /**
     * Helper method to add a unique param
     *
     * @param key   param key
     * @param value param value
     */
    public void addUniqueProperty(String key, String value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        if (!this.properties.containsKey(key)) this.properties.put(key, value);
    }

    @Override
    public String toString() {
        return "GradleBaseTasks{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", arguments=" + arguments +
                ", items=" + items +
                ", properties=" + properties +
                '}';
    }
}
