package com.beaverg.components.popup.search_popups;

import com.beaverg.base.BaseComponent;
import com.beaverg.pages.SearchPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModelPopupComponent extends BaseComponent {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title']")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text='Lancer']//following-sibling::android.widget.CheckBox")
    private WebElement lancerItemCheckbox;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement okButton;

    public ModelPopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Model popup component");
        return title.isDisplayed() && title.getAttribute("text").equals("Model");
    }

    public void clickLancerItemCheckBox() {
        swipeToText("Lancer");
        lancerItemCheckbox.click();
        REPORT.info("[INFO:] Lancer item checkbox was clicked");
    }

    public SearchPage clickOkButton() {
        okButton.click();
        REPORT.info("[INFO:] 'OK' button was clicked");
        return new SearchPage(driver);
    }
}
