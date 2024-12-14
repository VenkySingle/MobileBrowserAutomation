package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    public static AppiumDriver driver;
    public static Properties prop = new Properties();
    
    // Load properties file
    static {
        try (FileInputStream fileInput = new FileInputStream(".\\Resources\\testdata\\config\\Environment.properties")) {
            prop.load(fileInput);
            System.out.println("Properties loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading properties file.");
            e.printStackTrace();
        }
    }
    
    // Get capabilities for Android Web (Chrome browser)
    public static DesiredCapabilities GetCapsforBrowser() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", GetProperty("platform_Name"));
        cap.setCapability("platformVersion", GetProperty("Platform_Version"));
        cap.setCapability("deviceName", GetProperty("device_Name"));
        cap.setCapability("automationName", GetProperty("Automation_Name_Android"));
        cap.setCapability("browserName", GetProperty("Browser_Name"));
        // Make sure it's "Chrome"
       // cap.setCapability("appium:chromedriverExecutable", GetProperty("chromedriverExecutable"));

        return cap;
    }

    // Set up the Appium driver for Chrome on Android
    public static void getBrowserURL() {
        try {
        	WebDriverManager.chromedriver().setup();
            // No need for WebDriverManager for mobile automation
            driver = new AppiumDriver(new URL(GetProperty("appium_url")), GetCapsforBrowser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Fetch property from the properties file
    public static String GetProperty(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            System.out.println("Property " + key + " not found.");
        } else {
            System.out.println("Property " + key + " found with value: " + value);
        }
        return value;
    }
    
    // Return the driver instance
    public static AppiumDriver GetDriver() {
        if (driver == null) {
            getBrowserURL();
        }
        return driver;
    }
    
    public void TearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
      
    }
}
