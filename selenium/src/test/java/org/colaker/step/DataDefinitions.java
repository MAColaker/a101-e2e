package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DataDefinitions extends BaseDefinitions {

    @Step("<object> alanına <value> değeri yazılır")
    public void sendKeys(String object, String value){
        By by = mapper.getElementByJson(object);
        try {
            sendKeysHelper.sendKeys(by, value);
        }catch (Exception ignored){

        }
    }

    @Step("<object> objesinin değerinin <value> değerini içerdiği kontrol edilir")
    public void checkValue(String object, String value){
        By by = mapper.getElementByJson(object);
        Assert.assertTrue(storeHelper.getElementText(by).contains(value));
    }
}
