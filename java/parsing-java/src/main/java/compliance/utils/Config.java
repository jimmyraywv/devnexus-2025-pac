package compliance.utils;

import java.io.FileReader;
import java.util.Properties;

/**
 * Static config properties access point
 *
 * @author jimmyray
 * @version 1.0
 */
public final class Config {
    // File will be loaded from directory where Java command is invoked
    private static final String propertiesFile = "config.properties";
    public static final Properties properties;

    /// Static initializer
    static {
        properties = new Properties();
        // create a reader object on the properties file
        FileReader reader;
        try {
            reader = new FileReader(Config.propertiesFile);
            properties.load(reader);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}