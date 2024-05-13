package com.beaverg.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class Base {
    protected final AndroidDriver<MobileElement> driver;
    public static final Logger REPORT = LogManager.getLogger(BaseComponent.class);

    public Base(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void swipeToText(String text, double percentage){
        try {
            REPORT.info("[INFO]: Screen swiping");
            driver.findElementByAndroidUIAutomator(
                    String.format("new UiScrollable(new UiSelector().scrollable(true))" +
                            ".setSwipeDeadZonePercentage(%s).scrollIntoView(text(\"%s\"))", percentage, text));
            REPORT.info("[INFO]: Page was swiped");
        } catch (Exception e) {
            REPORT.info("[INFO]: Got a swiping error!");
            throw new RuntimeException(e);
        }
    }
}
