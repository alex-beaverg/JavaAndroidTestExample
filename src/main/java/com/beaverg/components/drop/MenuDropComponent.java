package com.beaverg.components.drop;

import com.beaverg.base.BaseElement;
import com.beaverg.components.popup.SaveSearchPopupComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuDropComponent extends BaseElement {
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Online Buying']")
    private WebElement onlineBuyingItem;

    public MenuDropComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SaveSearchPopupComponent clickOnlineBuyingItem() {
        onlineBuyingItem.click();
        REPORT.info("[INFO:] 'Online Buying' menu item was clicked");
        return new SaveSearchPopupComponent(driver);
    }
}
