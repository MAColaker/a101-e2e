package org.colaker.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SendKeysHelper extends BaseHelper{
    public void sendKeys(By by, String value) {
        waitHelper.untilElementDisplayed(by);
        WebElement element = waitHelper.untilElementClickable(by);
        element.clear();
        element.sendKeys(value);
    }
}
