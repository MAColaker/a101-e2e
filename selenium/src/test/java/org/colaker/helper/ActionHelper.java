package org.colaker.helper;

import org.colaker.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper extends BaseHelper{
    public Actions getActions(){
        return new Actions(Driver.webDriver);
    }

    public void moveToElement(By by){
        WebElement element = waitHelper.untilElementVisible(by);
        getActions().moveToElement(element).build().perform();
    }
}
