package com.beaverg.pages;

import com.beaverg.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineBuyingAutoCardPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text='Continue to order']")
    private WebElement elementForChecking;

    @FindBy(xpath = "//android.widget.TextView[@text='Fair price']//preceding-sibling::android.widget.TextView[1]")
    private WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text='Fair price']//preceding-sibling::android.widget.TextView[2]")
    private WebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text='First registration']//following-sibling::android.widget.TextView[1]")
    private WebElement firstRegistration;

    @FindBy(xpath = "//android.widget.TextView[@text='First registration']//preceding-sibling::android.widget.TextView")
    private WebElement mileage;

    @FindBy(xpath = "//android.widget.TextView[@text='Performance']//following-sibling::android.widget.TextView[1]")
    private WebElement performance;

    public OnlineBuyingAutoCardPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening AutoCard page");
        return elementForChecking.isDisplayed();
    }

    public String getTitle() {
        REPORT.info("[INFO:] Getting AutoCard title");
        return title.getText();
    }

    public int getPrice() {
        REPORT.info("[INFO:] Getting AutoCard price");
        return Integer.parseInt(price.getText()
                .replace(" €", "")
                .replace(".", ""));
    }

    public String getFirstRegistration() {
        swipeToText("First registration");
        REPORT.info("[INFO:] Getting AutoCard first registration");
        return firstRegistration.getText();
    }

    public int getMileage() {
        REPORT.info("[INFO:] Getting AutoCard mileage");
        return Integer.parseInt(mileage.getText()
                .replace("\u00a0km", "")
                .replace(",", ""));
    }

    public String getPerformance() {
        REPORT.info("[INFO:] Getting AutoCard performance");
        return performance.getText().replace("\u00a0", " ");
    }
}
