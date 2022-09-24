package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ActionsDefinitions extends BaseDefinitions {
    @Step("<object> objenin üzerine mouse ile gidilir")
    public void hoverElement(String object) {
        By by = mapper.getElementByJson(object);
        try {
            actionHelper.moveToElement(by);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
