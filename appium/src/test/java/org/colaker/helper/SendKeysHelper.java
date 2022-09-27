package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SendKeysHelper extends BaseHelper {
    public void sendKeys(By by, String value) {
        waitHelper.untilElementDisplayed(by);
        WebElement element = waitHelper.untilElementClickable(by);
        logger.info("'{}' elementi temizlendi", by);
        element.clear();
        logger.info("'{}' elementine '{}' değeri yazıldı", by, value);
        element.sendKeys(value);
    }
}
