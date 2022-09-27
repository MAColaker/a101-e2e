package org.colaker.helper;

import io.appium.java_client.MobileElement;
import org.colaker.base.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class WaitHelper {
    protected static final Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    public void untilElementDisplayed(By by) {
        untilElementVisible(by);
    }

    public MobileElement untilElementVisible(By by) {
        return (MobileElement) BaseHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean untilElementInVisible(By by) {
        return BaseHelper.wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public MobileElement untilElementClickable(By by) {
        return (MobileElement) BaseHelper.wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void secondPause(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
