package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogManager {
    public static final Logger logger;

    static {
        // Load the properties file
        try {
            PropertyConfigurator.configure("Resources/testdata/log4j.properties");
            System.out.println("Log4j initialized successfully!");
        } catch (Exception e) {
            System.err.println("Failed to initialize Log4j: " + e.getMessage());
        }
        logger = Logger.getLogger("steps.BrowserInteractions");
    }
}
