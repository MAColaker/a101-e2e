package org.colaker.helper;

import org.openqa.selenium.By;

public class StoreHelper extends BaseHelper{
    public String getElementText(By by){
        return waitHelper.untilElementVisible(by).getText();
    }
}
