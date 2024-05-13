package com.beaverg.components.popup;

import com.beaverg.base.BaseComponent;
import com.beaverg.pages.AutoCardsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveSearchPopupComponent extends BaseComponent {
    @FindBy(xpath = "//android.widget.TextView[@text='Save your search']")
    private WebElement title;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Save search']")
    private WebElement saveSearchButton;

    public SaveSearchPopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Save Search component");
        return title.isDisplayed();
    }

    public AutoCardsPage clickSaveSearchButton() {
        saveSearchButton.click();
        REPORT.info("[INFO:] 'Save Search' button was clicked");
        return new AutoCardsPage(driver);
    }
}
