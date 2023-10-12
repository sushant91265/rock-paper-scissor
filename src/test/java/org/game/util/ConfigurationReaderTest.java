package org.game.util;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

//IntegrationTest
public class ConfigurationReaderTest {

    @Test
    public void testLoadGameProperties() {
        ConfigurationReader configurationReader = new ConfigurationReader();
        String path = "src/test/resources/game.properties";
        Properties properties = configurationReader.loadGameProperties(path);

        assertEquals("expectedValue1", properties.getProperty("key1"));
        assertEquals("expectedValue2", properties.getProperty("key2"));
    }

    @Test
    public void testLoadNonExistentFile() {
        ConfigurationReader configurationReader = new ConfigurationReader();

        String nonExistentFilePath = "src/test/resources/non_game.properties";

        assertTrue(configurationReader.loadGameProperties(nonExistentFilePath).isEmpty());
    }

    @Test
    public void testEmptyFile() {
        String emptyFilePath = "src/test/resources/empty_game.properties";

        ConfigurationReader configurationReader = new ConfigurationReader();
        assertThrows(RuntimeException.class, () -> {
            configurationReader.loadGameProperties(emptyFilePath);
        });
    }
}