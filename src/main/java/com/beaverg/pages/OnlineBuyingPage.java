package com.beaverg.pages;

import com.beaverg.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlineBuyingPage extends BasePage {
    @FindBy(xpath = "//android.widget.Button[@text='Online-Buying']")
    private WebElement onlineBuyingFilter;

    @FindBy(id = "headline")
    List<WebElement> autoCardTitles;

    @FindBy(id = "price1")
    List<WebElement> autoCardPrices;

    @FindBy(id = "details_line_1")
    List<WebElement> autoCardDetails;

    public OnlineBuyingPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening Online Buying page");
        return onlineBuyingFilter.isDisplayed();
    }

    public String getTitleByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting AutoCard title by index=%d", index));
        return autoCardTitles.get(index).getText();
    }

    public int getPriceByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting AutoCard price by index=%d", index));
        return Integer.parseInt(autoCardPrices.get(index).getText()
                .replace("€", "")
                .replace(",", "")
                .replace("\u00a0¹", ""));
    }

    public String getFirstRegistrationByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting AutoCard first registration by index=%d", index));
        return autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[0]
                .replace("FR ", "");
    }

    public int getMileageByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting AutoCard mileage by index=%d", index));
        return Integer.parseInt(autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[1]
                .replace("\u00a0km", "")
                .replace(",", ""));
    }

    public String getPerformanceByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting AutoCard performance by index=%d", index));
        return autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[2]
                .replace("\u00a0", " ");
    }

    public AutoCardPage clickAutoCardByIndex(int index) {
        autoCardTitles.get(index).click();
        REPORT.info(String.format("[INFO:] AutoCard by index=%d was clicked", index));
        return new AutoCardPage(driver);
    }
}
