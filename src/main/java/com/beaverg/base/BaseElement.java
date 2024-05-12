package com.beaverg.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class BaseElement {
    protected final AndroidDriver<MobileElement> driver;
    public static final Logger REPORT = LogManager.getLogger(BaseElement.class);

    public BaseElement(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
