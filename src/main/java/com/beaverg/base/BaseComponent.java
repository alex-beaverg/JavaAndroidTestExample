package com.beaverg.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class BaseComponent extends Base {

    public BaseComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract boolean isComponentOpen();
}
