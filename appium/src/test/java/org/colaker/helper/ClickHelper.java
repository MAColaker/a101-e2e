package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;

public class ClickHelper extends BaseHelper {
    public void click(By by) {
        waitHelper.untilElementDisplayed(by);
        logger.info("'{}' elemente tıklanıyor", by);
        waitHelper.untilElementClickable(by).click();
        logger.info("'{}' elementine tıklama işlemi gerçekleştirildi", by);
    }
}
