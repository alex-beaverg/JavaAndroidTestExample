package com.beaverg.components.drop;

import com.beaverg.base.BaseComponent;
import com.beaverg.components.popup.SaveSearchPopupComponent;
import com.beaverg.pages.SearchPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuDropComponent extends BaseComponent {
    @FindBy(id = "nav_header")
    private WebElement header;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Online Buying']")
    private WebElement onlineBuyingItem;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Search']")
    private WebElement searchItem;

    public MenuDropComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isComponentOpen() {
        REPORT.info("[INFO:] Checking opening Menu drop component");
        return header.isDisplayed();
    }

    public SaveSearchPopupComponent clickOnlineBuyingItem() {
        onlineBuyingItem.click();
        REPORT.info("[INFO:] 'Online Buying' menu item was clicked");
        return new SaveSearchPopupComponent(driver);
    }

    public SearchPage clickSearchItem() {
        searchItem.click();
        REPORT.info("[INFO:] 'Search' menu item was clicked");
        return new SearchPage(driver);
    }
}
