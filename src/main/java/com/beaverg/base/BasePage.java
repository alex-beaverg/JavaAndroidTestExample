package com.beaverg.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage extends Base {

    public BasePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract boolean isPageOpen();
}
