package com.beaverg.components.popup;

import com.beaverg.base.BaseComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BenefitsPopupComponent extends BaseComponent {
    @FindBy(xpath = "//android.widget.TextView[@text='Up to date on benefits']")
    private WebElement title;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    private WebElement cancelButton;

    public BenefitsPopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Benefits popup component");
        return title.isDisplayed();
    }

    public void clickCancelButton() {
        cancelButton.click();
        REPORT.info("[INFO:] 'Cancel' button was clicked");
    }
}
