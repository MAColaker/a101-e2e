package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SelectDefinitions extends BaseDefinitions {
    @Step("<object> listesinden <text> değeri seçilir")
    public void selectOption(String object, String text) {
        By by = mapper.getElementByJson(object);
        try {
            selectHelper.selectByVisibleText(by, text);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
