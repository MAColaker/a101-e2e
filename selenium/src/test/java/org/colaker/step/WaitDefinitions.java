package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class WaitDefinitions extends BaseDefinitions {

    @Step("<object> objesinin bulunduğu kontrol edilir")
    public void checkVisible(String object){
        By by = mapper.getElementByJson(object);
        assertTrue(visibleHelper.isElementVisible(by));
    }

    @Step("<object> objesi görünene kadar beklenir")
    public void waitUntilElementApper(String object){
        By by = mapper.getElementByJson(object);
        visibleHelper.isElementVisible(by);
    }

    @Step("<second> saniye beklenir")
    public void waitSecond(int second){
        waitHelper.secondPause(second);
    }

    @Step("<object> objesi kaybolana kadar beklenir")
    public void waitUntilElementInVisible(String object){
        By by = mapper.getElementByJson(object);
        visibleHelper.isElementNotVisible(by);
    }
}
