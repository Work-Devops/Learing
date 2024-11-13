package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    // Method to initialize WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            // Corrected path for chromedriver
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\MarioKumar\\Downloads\\Chrome.driver\\chromedriver-win64\\chromedriver.exe");
            		 
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();  
            driver = null;
        }
    }
}
