package com.beaverg.base;

import com.beaverg.components.popup.PrivacyPopupComponent;
import com.beaverg.pages.HomePage;
import com.beaverg.utils.AndroidDriverService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class BaseTest {
    protected AndroidDriver<MobileElement> driver;
    private final File tempLogFile = new File("target/test_report.log");

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = AndroidDriverService.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        try {
            Allure.addAttachment("Log", FileUtils.openInputStream(tempLogFile));
            FileUtils.write(tempLogFile, "", Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Allure.addAttachment("Message", String.format("Test '%s' was completed successfully!", result.getName()));
        AndroidDriverService.closeDriver();
    }

    protected HomePage getHomePage() {
        SoftAssert sa = new SoftAssert();

        PrivacyPopupComponent privacyPopupComponent = new PrivacyPopupComponent(driver);
        sa.assertTrue(privacyPopupComponent.isComponentOpen(), "Privacy popup component isn't open!");

        HomePage homePage = privacyPopupComponent.clickAcceptPrivacyButton();
        sa.assertTrue(homePage.isPageOpen(), "Home page isn't open!");

        sa.assertAll();
        return homePage;
    }
}
