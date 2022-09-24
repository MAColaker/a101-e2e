package org.colaker.driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;
    public static WebDriverWait wait;
    int timeOut = Integer.parseInt(System.getenv("TIMEOUT"));
    int sleepInMillis = Integer.parseInt(System.getenv("SLEEP_IN_MILLIS"));

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
        wait = new WebDriverWait(Driver.webDriver, Duration.ofSeconds(timeOut), Duration.ofMillis(sleepInMillis));
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }

}
