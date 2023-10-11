package org.game.util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class reads the properties file and returns the Properties object.
 */
@Slf4j
public class ConfigurationReader {

    private static final String GAME_PROPERTIES_FILE = "src/main/resources/game.properties";

    public Properties loadGameProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(GAME_PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            log.error("Error loading game properties. Exiting...");
            log.debug("Exception: ", e);
        }
        return properties;
    }
}
