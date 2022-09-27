package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class VisibleHelper extends BaseHelper {
    public boolean isElementVisible(By by) {
        return waitHelper.untilElementVisible(by) != null;
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean waitUntilElemenDisappear(By by) {
        return waitHelper.untilElementInVisible(by);
    }
}
