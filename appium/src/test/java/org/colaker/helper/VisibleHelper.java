package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;

public class VisibleHelper extends BaseHelper {
    public boolean isElementVisible(By by) {
        return waitHelper.untilElementVisible(by) != null;
    }

    public boolean isDisplayed(By by){
        return driver.findElement(by).isDisplayed();
    }

    public boolean waitUntilElemenDisappear(By by) {
        return waitHelper.untilElementInVisible(by);
    }
}
