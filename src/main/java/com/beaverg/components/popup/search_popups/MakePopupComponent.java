package com.beaverg.components.popup.search_popups;

import com.beaverg.base.BaseComponent;
import com.beaverg.pages.SearchPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MakePopupComponent extends BaseComponent {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title']")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text='Mitsubishi']")
    private WebElement mitsubishiItem;

    public MakePopupComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Make popup component");
        return title.isDisplayed() && title.getAttribute("text").equals("Make");
    }

    public ModelPopupComponent clickMitsubishiItem() {
        swipeToText("Mitsubishi", 0.15);
        mitsubishiItem.click();
        return new ModelPopupComponent(driver);
    }
}
