package org.colaker.helper;

import org.openqa.selenium.By;

public class VisibleHelper extends BaseHelper{
    public boolean isElementVisible(By by){
        return waitHelper.untilElementVisible(by) != null;
    }

    public void isElementNotVisible(By by){
        waitHelper.untilElementInVisible(by);
    }
}
