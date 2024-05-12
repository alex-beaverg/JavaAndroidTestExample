package com.beaverg.components.popup;

import com.beaverg.base.BaseElement;
import com.beaverg.pages.OnlineBuyingPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveSearchPopupComponent extends BaseElement {
    @FindBy(xpath = "//android.widget.Button[@content-desc='Save search']")
    private WebElement saveSearchButton;

    public SaveSearchPopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public OnlineBuyingPage clickComponentBody() {
        saveSearchButton.click();
        REPORT.info("[INFO:] 'Save Search' button was clicked");
        return new OnlineBuyingPage(driver);
    }
}
