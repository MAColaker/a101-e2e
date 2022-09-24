package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class WaitDefinitions extends BaseDefinitions {

    @Step("<object> objesinin bulunduğu kontrol edilir")
    public void checkVisible(String object) {
        By by = mapper.getElementByJson(object);
        try {
            assertTrue(by + ": elementi görünür değil", visibleHelper.isElementVisible(by));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Step("<object> objesi görünene kadar beklenir")
    public void waitUntilElementAppear(String object) {
        By by = mapper.getElementByJson(object);
        try {
            visibleHelper.isElementVisible(by);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Step("<second> saniye beklenir")
    public void waitSecond(int second) {
        waitHelper.secondPause(second);
    }

    @Step("<object> objesi kaybolana kadar beklenir")
    public void waitUntilElementInVisible(String object) {
        By by = mapper.getElementByJson(object);
        try {
            Assert.assertTrue(by+": elementi kaybolmadı",visibleHelper.waitUntilElemenDisappear(by));
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
