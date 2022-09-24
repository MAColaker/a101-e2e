package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DataDefinitions extends BaseDefinitions {

    @Step("<object> alanına <value> değeri yazılır")
    public void sendKeys(String object, String value) {
        By by = mapper.getElementByJson(object);
        try {
            sendKeysHelper.sendKeys(by, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Step("<object> objesinin değerinin <value> değerini içerdiği kontrol edilir")
    public void checkValue(String object, String value) {
        By by = mapper.getElementByJson(object);
        logger.info("Aranan değer: '{}'", value);
        try {
            Assert.assertTrue("Bulunan değer ile aranan değer eşleşmiyor",
                    storeHelper.getElementText(by).contains(value));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
