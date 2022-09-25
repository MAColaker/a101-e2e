package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ClickDefinitions extends BaseDefinitions {

    @Step("<key> objesine tıklanır")
    public void clickElement(String key) {
        By by = mapper.getElementByJson(key);
        try {
            clickHelper.click(by);
        } catch (Exception e) {
            logger.error("'{}' elementine tıklanırken hata alındı", by);
            logger.error(e.getMessage(), e);
            Assert.fail(by + "elementine tıklanrken hata alındı\n" + e.getMessage());
        }
    }

    @Step("<key> objesi varsa tıklanır")
    public void clickElementIfExist(String key) {
        By by = mapper.getElementByJson(key);
        if (visibleHelper.isElementVisible(by)) {
            try {
                clickHelper.click(by);
            } catch (Exception e) {
                logger.error("'{}' elementine tıklanırken hata alındı", by);
                logger.error(e.getMessage(), e);
                Assert.fail(by + "elementine tıklanrken hata alındı\n" + e.getMessage());
            }
        } else {
            logger.error("'{}' elementine tıklanırken hata alındı", by);
            Assert.fail(by + "elementi bulunamadı");
        }
    }
}
