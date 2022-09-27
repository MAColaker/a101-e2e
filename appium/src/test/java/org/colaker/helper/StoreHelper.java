package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;

public class StoreHelper extends BaseHelper {
    public String getElementText(By by) {
        String text = waitHelper.untilElementVisible(by).getText();
        logger.info("Bulunan değer: '{}'", text);
        return text;
    }
}
