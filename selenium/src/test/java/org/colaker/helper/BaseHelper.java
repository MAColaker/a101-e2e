package org.colaker.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseHelper {
    protected static final Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    protected WaitHelper waitHelper = new WaitHelper();
}
