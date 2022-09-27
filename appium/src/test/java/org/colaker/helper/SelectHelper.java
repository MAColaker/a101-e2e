package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper extends BaseHelper {
    public void selectByVisibleText(By by, String text) {
        logger.info("'{}' elementi aranıyor", by);
        Select select = new Select(waitHelper.untilElementClickable(by));
        logger.info("'{}' select objesinden '{}' değeri seçiliyor", by, text);
        select.selectByVisibleText(text);
    }
}
