package org.guardiandev.helloservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Loads config from environment in the following order:
 * - loads all properties in integrationTest/resources/config.properties
 * - loads all environment variables
 *
 * if a value is specified in both the config.properties and as an environment variable, you will get the environment
 * variable value
 */
public final class TestPropertiesContainer {

    private static Logger LOGGER = LoggerFactory.getLogger(TestPropertiesContainer.class);

    private final Properties properties;

    public TestPropertiesContainer() {
        try {
            properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            Map<String, String> environment = System.getenv();
            environment.forEach(properties::setProperty);
        } catch (IOException e) {
            LOGGER.error("failed to load properties for tests");
            throw new RuntimeException(e);
        }
    }

    public String getValue(String propertyName) {
        return (String)properties.get(propertyName);
    }

    public String getValueOrDefault(String propertyName, String defaultValue) {
        Object value = properties.get(propertyName);
        if(value == null) {
            return defaultValue;
        }
        return (String)value;
    }
}
