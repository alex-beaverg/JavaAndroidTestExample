package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.components.drop.MenuDropComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement title;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation bar']")
    private WebElement menuButton;

    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public MenuDropComponent clickOpenMenuButton() {
        menuButton.click();
        REPORT.info("[INFO:] 'Menu' button was clicked");
        return new MenuDropComponent(driver);
    }

    @Override
    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening Home page");
        return title.getText().contains("Home");
    }
}
