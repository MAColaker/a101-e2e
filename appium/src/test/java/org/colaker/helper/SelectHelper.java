package org.colaker.helper;

import org.colaker.base.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectHelper extends BaseHelper {
    VisibleHelper visibleHelper = new VisibleHelper();

    public void selectByVisibleText(By by, String text) {
        logger.info("'{}' elementi aranıyor", by);
        WebElement spinner = waitHelper.untilElementClickable(by);
        spinner.click();

        By elementOptionBy = By.xpath("//android.widget.ListView/android.widget.CheckedTextView[@text='" + text + "']");
        logger.info("Ekran kaydırılacak");
        while (!visibleHelper.isDisplayed(elementOptionBy)) {
            logger.info("Ekran yukarı kaydırıldı");
            verticalSwipeByPercentages(0.7, 0.2, 0.5);
        }
        WebElement element = waitHelper.untilElementClickable(elementOptionBy);
        logger.info("'{}' select objesinden '{}' değeri seçiliyor", by, text);
        element.click();
    }
}
