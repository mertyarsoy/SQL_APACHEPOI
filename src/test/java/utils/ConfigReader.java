package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperty(String key){
        File file = new File("database.properties");
        Properties properties = new Properties();
        // this properties object will read the properties file
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException("Could not find properties file",e);
        }

        return properties.getProperty(key);
    }
}
