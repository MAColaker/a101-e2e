package org.colaker.helper;

import org.openqa.selenium.By;

public class ClickHelper extends BaseHelper{
    public void click(By by){
        waitHelper.untilElementDisplayed(by);
        waitHelper.untilElementClickable(by).click();
    }
}
