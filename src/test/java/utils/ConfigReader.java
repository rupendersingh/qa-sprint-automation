package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "qa");
        String fileName = "config-" + env + ".properties";

        try (InputStream input =
                     ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
