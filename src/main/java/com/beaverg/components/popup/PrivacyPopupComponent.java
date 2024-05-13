package com.beaverg.components.popup;

import com.beaverg.base.BaseComponent;
import com.beaverg.pages.HomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPopupComponent extends BaseComponent {

    @FindBy(id = "consent_accept_button")
    private WebElement acceptPrivacyButton;

    @FindBy(id = "consent_banner_text_p2")
    private WebElement privacyText;

    public PrivacyPopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public HomePage clickAcceptPrivacyButton() {
        acceptPrivacyButton.click();
        REPORT.info("[INFO:] 'Accept Privacy' button was clicked");
        return new HomePage(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Privacy popup component");
        return privacyText.getText().contains("Privacy");
    }
}
