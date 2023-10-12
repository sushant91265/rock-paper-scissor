package org.game.util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads the properties file and returns the Properties object.
 */
@Slf4j
public class ConfigurationReader {

    public Properties loadGameProperties(String filePath) {
        Properties properties = new Properties();
        try (InputStream fis = new FileInputStream(filePath)) {
            if (fis.available() == 0) {
                log.error("Undefined game rules!");
                throw new RuntimeException("Undefined game rules!");
            }
            properties.load(fis);
        } catch (IOException e) {
            log.error("Error loading game properties.", e);
        }
        return properties;
    }
}
