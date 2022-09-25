package org.colaker.step;

import com.thoughtworks.gauge.Step;
import org.colaker.Mapper.Mapper;
import org.colaker.driver.Driver;
import org.colaker.helper.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDefinitions {
    protected static final Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    protected Mapper mapper = new Mapper();
    protected WaitHelper waitHelper = new WaitHelper();
    protected VisibleHelper visibleHelper = new VisibleHelper();
    protected ClickHelper clickHelper = new ClickHelper();
    protected SendKeysHelper sendKeysHelper = new SendKeysHelper();
    protected StoreHelper storeHelper = new StoreHelper();
    protected ActionHelper actionHelper = new ActionHelper();
    protected SelectHelper selectHelper = new SelectHelper();

    @Step("Anasayfaya gidilir")
    public void navigateToHomePage() {
        String app_url = System.getenv("APP_URL");
        try {
            Driver.webDriver.get(app_url + "/");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
