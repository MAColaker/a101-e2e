package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

public class ClickDefinitions extends BaseDefinitions {

    @Step("<key> objesine tıklanır")
    public void clickElement(String key){
        By by = mapper.getElementByJson(key);
        try {
            clickHelper.click(by);
        }catch (Exception ignored){

        }
    }

    @Step("<key> objesi varsa tıklanır")
    public void clickElementIfExist(String key){
        By by = mapper.getElementByJson(key);
        if (visibleHelper.isElementVisible(by))
            clickHelper.click(by);
        else
            System.out.println("Element bulunamadı");
    }
}
