package com.beaverg.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.beaverg.utils.Printers.*;

public class AndroidDriverService {
    public static AndroidDriver<MobileElement> driver;

    private AndroidDriverService() {}

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyGetter.getProperty("caps.deviceName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyGetter.getProperty("caps.platformName"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertyGetter.getProperty("caps.automationName"));
            capabilities.setCapability(MobileCapabilityType.APP, PropertyGetter.getProperty("caps.app"));
            capabilities.setCapability(MobileCapabilityType.NO_RESET, PropertyGetter.getProperty("caps.noReset"));
            try {
                driver = new AndroidDriver<>(new URL(PropertyGetter.getProperty("selenium_url")), capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                PRINTLN.info(e.getMessage());
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
