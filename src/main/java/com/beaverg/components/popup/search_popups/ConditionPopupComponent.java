package com.beaverg.components.popup.search_popups;

import com.beaverg.base.BaseComponent;
import com.beaverg.pages.SearchPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConditionPopupComponent extends BaseComponent {
    @FindBy(id = "alertTitle")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text='Used']//following-sibling::android.widget.RadioButton")
    private WebElement usedRadioButton;

    public ConditionPopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Condition popup component");
        return title.isDisplayed() && title.getAttribute("text").equals("Condition");
    }

    public SearchPage clickUsedRadioButton() {
        usedRadioButton.click();
        REPORT.info("[INFO:] 'Used' radio button was clicked");
        return new SearchPage(driver);
    }
}
