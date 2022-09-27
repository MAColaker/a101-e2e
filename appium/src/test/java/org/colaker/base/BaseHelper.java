package org.colaker.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.colaker.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class BaseHelper {
    private static final String PAGES_DIRECTORY_PATH = "org/colaker/pages";
    private static final String PAGES_PACKAGE_NAME = "org.colaker.pages.";
    public static AppiumDriver<MobileElement> driver;
    public static FluentWait<AppiumDriver<MobileElement>> wait;
    protected static Map<String, Field> fieldMap = new HashMap<>();
    public final Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    protected WaitHelper waitHelper = new WaitHelper();

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_UNLOCK, "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

        capabilities.setCapability("appPackage", "org.studionord.a101");
        capabilities.setCapability("appActivity", "org.studionord.a101.MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<>(url, capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new FluentWait<>(driver);
        wait.withTimeout(ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        initFileList(getFileList());
    }

    public By getElementBy(String key) {
        try {
            Object oClass = Class.forName(fieldMap.get(key).getDeclaringClass().getName()).newInstance();
            Object field = fieldMap.get(key).get(oClass);
            return (By) field;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void initFileList(File[] files) {
        for (File file : files) {
            try {
                Class<?> c = Class.forName(PAGES_PACKAGE_NAME + file.getName().split("\\.")[0]);
                Field[] fields = c.getFields();
                for (Field field : fields) {
                    fieldMap.put(field.getName(), field);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private File[] getFileList() {
        return new File(BasePage.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                PAGES_DIRECTORY_PATH).listFiles(pathname -> pathname.getName().endsWith(".class"));
    }

    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }

    @After
    public void afterScenario() {
        if (driver != null)
            driver.quit();
    }
}
