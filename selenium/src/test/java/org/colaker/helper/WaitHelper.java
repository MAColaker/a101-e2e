package org.colaker.helper;

import org.colaker.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class WaitHelper {
    public void untilElementDisplayed(By by){
        untilElementVisible(by);
    }

    public WebElement untilElementVisible(By by){
        return Driver.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public Boolean untilElementInVisible(By by){
        return Driver.wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement untilElementClickable(By by){
        return Driver.wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void secondPause(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        }catch (Exception ignored){

        }
    }
}
