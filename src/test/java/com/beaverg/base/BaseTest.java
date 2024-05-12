package com.beaverg.base;

import com.beaverg.utils.AndroidDriverService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected AndroidDriver<AndroidElement> driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = AndroidDriverService.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        AndroidDriverService.closeDriver();
    }
}
