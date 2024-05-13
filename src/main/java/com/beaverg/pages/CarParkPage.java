package com.beaverg.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarParkPage extends AutoCardsPage {
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation bar']//following-sibling::android.widget.TextView")
    private WebElement title;

    @FindBy(id = "listing_details")
    private List<WebElement> autoCardDetails;

    public CarParkPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening Car Park page");
        return title.isDisplayed() && title.getText().contains("Car Park");
    }

    @Override
    public String getFirstRegistrationByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card first registration by index=%d", index));
        return autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[0]
                .replace("FR ", "");
    }

    @Override
    public int getMileageByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card mileage by index=%d", index));
        return Integer.parseInt(autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[1]
                .replace("\u00a0km", "")
                .replace(",", ""));
    }

    @Override
    public String getPerformanceByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card performance by index=%d", index));
        return autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[2]
                .replace("\u00a0", " ");
    }
}
