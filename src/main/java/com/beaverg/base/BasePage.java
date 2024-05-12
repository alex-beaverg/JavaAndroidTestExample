package com.beaverg.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage extends BaseElement {

    public BasePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    protected void swipeToText(String text){
        try {
            driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                            ".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))");
            REPORT.info("[INFO]: Page was swiped");
        } catch (Exception e) {
            REPORT.info("[INFO]: Got a swiping error!");
        }
    }

}
