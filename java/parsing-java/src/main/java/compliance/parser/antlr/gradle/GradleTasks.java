package compliance.parser.antlr.gradle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface GradleTasks {

    List<String> VALID_GRADLE_TASKS_TYPES = Arrays.asList("lifecycle", "named", "register");

    List<String> VALID_GRADLE_DEPENDENCY_CFG_TYPES =
            Arrays.asList("api", "implementation", "compileOnly", "compileOnlyApi", "runtimeOnly", "testImplementation",
                    "testCompileOnly", "testRuntimeOnly");

    String getType();

    String getName();

    List<String> getArguments();

    List<String> getItems();

    Map<String, String> getProperties();
}
