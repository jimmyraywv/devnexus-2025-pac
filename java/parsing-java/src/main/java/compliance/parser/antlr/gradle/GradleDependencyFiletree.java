package compliance.parser.antlr.gradle;

import java.util.ArrayList;
import java.util.List;

public class GradleDependencyFiletree {
    private List<String> arguments;
    private List<String> entries;

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }

    /**
     * Helper method to add an argument
     *
     * @param argument to be added
     */
    public void addArgument(String argument) {
        if (this.arguments == null) {
            this.arguments = new ArrayList<>();
        }
        this.arguments.add(argument);
    }

    /**
     * Helper method to add a unique argument
     *
     * @param argument to be added
     */
    public void addUniqueArgument(String argument) {
        if (this.arguments == null) {
            this.arguments = new ArrayList<>();
        }

        if (!this.arguments.contains(argument)) this.arguments.add(argument);
    }

    /**
     * Helper method to add an entry
     *
     * @param entry to be added
     */
    public void addEntry(String entry) {
        if (this.entries == null) {
            this.entries = new ArrayList<>();
        }
        this.entries.add(entry);
    }

    /**
     * Helper method to add a unique entry
     *
     * @param entry to be added
     */
    public void addUniqueEntry(String entry) {
        if (this.entries == null) {
            this.entries = new ArrayList<>();
        }

        if (!this.entries.contains(entry)) this.entries.add(entry);
    }

    @Override
    public String toString() {
        return "GradleDependencyFiletree{" +
                "arguments=" + arguments +
                ", entries=" + entries +
                '}';
    }
}
