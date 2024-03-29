package org.colaker.helper;

import org.colaker.model.ElementInfo;
import org.openqa.selenium.By;

public class ElementHelper {
    public static By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        switch (elementInfo.getType()) {
            case "id":
                by = By.id(elementInfo.getValue());
                break;
            case ("name"):
                by = By.name(elementInfo.getValue());
                break;
            case "css":
                by = By.cssSelector(elementInfo.getValue());
                break;
            case "xpath":
                by = By.xpath(elementInfo.getValue());
                break;
            case "linkText":
                by = By.linkText(elementInfo.getValue());
                break;
            case ("partialLinkText"):
                by = By.partialLinkText(elementInfo.getValue());
                break;
        }
        return by;
    }
}
