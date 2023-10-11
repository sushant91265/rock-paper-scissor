package org.game.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final String GAME_PROPERTIES_FILE = "src/main/resources/game.properties";
    private static final Logger log = LoggerFactory.getLogger(ConfigurationReader.class);

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
