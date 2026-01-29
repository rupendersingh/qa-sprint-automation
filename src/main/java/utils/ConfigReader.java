package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config/mobile.properties"
            );
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load mobile.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

