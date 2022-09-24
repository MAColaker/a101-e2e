package org.colaker.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectHelper extends BaseHelper{
    public void selectByVisibleText(By by, String text){
        WebElement element = waitHelper.untilElementVisible(by);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}
