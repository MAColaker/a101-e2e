package org.colaker.step;

import io.cucumber.java.en.*;
import org.colaker.base.BaseHelper;
import org.colaker.helper.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    BaseHelper baseHelper = new BaseHelper();
    ClickHelper clickHelper = new ClickHelper();
    WaitHelper waitHelper = new WaitHelper();
    StoreHelper storeHelper = new StoreHelper();
    VisibleHelper visibleHelper = new VisibleHelper();
    SendKeysHelper sendKeysHelper = new SendKeysHelper();
    SelectHelper selectHelper = new SelectHelper();

    @Given("^(.*) elementi görünene kadar beklenir")
    public void waitUntilElementAppear(String object) {
        try {
            By by = baseHelper.getElementBy(object);
            waitHelper.untilElementDisplayed(by);
        } catch (Exception e) {
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Given("^(.*) objesine tıklanır")
    public void clickElement(String key) {
        By by = baseHelper.getElementBy(key);
        try {
            clickHelper.click(by);
        } catch (Exception e) {
            baseHelper.logger.error("'{}' elementine tıklanırken hata alındı", by);
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(by + "elementine tıklanrken hata alındı\n" + e.getMessage());
        }
    }

    @Given("^(.*) saniye beklenir")
    public void waitSecond(int second) {
        waitHelper.secondPause(second);
    }

    @Given("^(.*) objesi kaybolana kadar beklenir")
    public void waitUntilElementInVisible(String object) {
        By by = baseHelper.getElementBy(object);
        try {
            Assert.assertTrue(by + ": elementi kaybolmadı", visibleHelper.waitUntilElemenDisappear(by));
        } catch (Exception e) {
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Given("^(.*) objesinin değerinin '(.*)' değerini içerdiği kontrol edilir")
    public void checkValue(String object, String value) {
        By by = baseHelper.getElementBy(object);
        baseHelper.logger.info("Aranan değer: '{}'", value);
        try {
            Assert.assertTrue("Bulunan değer ile aranan değer eşleşmiyor",
                    storeHelper.getElementText(by).contains(value));
        } catch (Exception e) {
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Given("^(.*) elementi görünene kadar max '(.*)' defa ekranı yukarı kaydır")
    public void findByKeyWithSwipe(String key, int count) {
        while (!visibleHelper.isDisplayed(baseHelper.getElementBy(key)) && count > 0) {
            --count;
            baseHelper.verticalSwipeByPercentages(0.1, 0.1, 0.5);
            baseHelper.verticalSwipeByPercentages(0.6, 0.3, 0.5);
            baseHelper.logger.info("Ekran yukarı kaydırıldı");
        }
    }

    @Given("^(.*) kere ekranı yukarı kaydır")
    public void swipeUpLoop(int count) {
        while (count>0) {
            --count;
            baseHelper.verticalSwipeByPercentages(0.1, 0.1, 0.5);
            baseHelper.verticalSwipeByPercentages(0.8, 0.2, 0.5);
            baseHelper.logger.info("Ekran yukarı kaydırıldı");
        }
    }

    @Given("^Ekrana dokun")
    public void clickScreen(){
        baseHelper.verticalSwipeByPercentages(0.5, 0.5, 0.5);
        baseHelper.logger.info("Ekrana dokunuldu");
    }

    @Given("^(.*) alanına '(.*)' değeri yazılır")
    public void sendKeys(String object, String value) {
        By by = baseHelper.getElementBy(object);
        try {
            sendKeysHelper.sendKeys(by, value);
        } catch (Exception e) {
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Given("^(.*) listesinden '(.*)' değeri seçilir")
    public void selectOption(String object, String text) {
        By by = baseHelper.getElementBy(object);
        try {
            selectHelper.selectByVisibleText(by, text);
        } catch (Exception e) {
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }

    @Given("^(.*) objesinin bulunduğu kontrol edilir")
    public void checkVisible(String object) {
        By by = baseHelper.getElementBy(object);
        try {
            assertTrue(by + ": elementi görünür değil", visibleHelper.isElementVisible(by));
        } catch (Exception e) {
            baseHelper.logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
