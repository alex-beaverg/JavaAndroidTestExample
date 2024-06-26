package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.components.popup.BenefitsPopupComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutoCardsPage extends BasePage {
    @FindBy(id = "chip_filter")
    private WebElement addFilter;

    @FindBy(id = "headline")
    private List<WebElement> autoCardTitles;

    @FindBy(id = "price1")
    private List<WebElement> autoCardPrices;

    @FindBy(id = "details_line_1")
    private List<WebElement> autoCardDetails;

    @FindBy(id = "option_park_obs")
    private List<WebElement> addToCarParkButtons;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private WebElement goBackButton;

    public AutoCardsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening Auto Cards page");
        return addFilter.isDisplayed();
    }

    public String getTitleByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card title by index=%d", index));
        return autoCardTitles.get(index).getText()
                .replace("Sponsored", "")
                .replace("New", "")
                .replace("\u00a0", "").strip();
    }

    public int getPriceByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card price by index=%d", index));
        return Integer.parseInt(autoCardPrices.get(index).getText()
                .replace("€", "")
                .replace(",", "")
                .replace("\u00a0¹", ""));
    }

    public String getFirstRegistrationByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card first registration by index=%d", index));
        return autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[0]
                .replace("FR ", "");
    }

    public int getMileageByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card mileage by index=%d", index));
        return Integer.parseInt(autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[1]
                .replace("\u00a0km", "")
                .replace(",", ""));
    }

    public String getPerformanceByIndex(int index) {
        REPORT.info(String.format("[INFO:] Getting Auto Card performance by index=%d", index));
        return autoCardDetails.get(index).getText()
                .replace("Accident-free\u00a0• ", "")
                .split("\u00a0• ")[2]
                .replace("\u00a0", " ");
    }

    public OnlineBuyingAutoCardPage clickOnlineBuyingAutoCardByIndex(int index) {
        autoCardTitles.get(index).click();
        REPORT.info(String.format("[INFO:] Auto Card by index=%d was clicked", index));
        return new OnlineBuyingAutoCardPage(driver);
    }

    public SearchAutoCardPage clickSearchAutoCardByIndex(int index) {
        autoCardTitles.get(index).click();
        REPORT.info(String.format("[INFO:] Auto Card by index=%d was clicked", index));
        return new SearchAutoCardPage(driver);
    }

    public BenefitsPopupComponent clickAddToCarParkButtonByIndex(int index) {
        addToCarParkButtons.get(index).click();
        REPORT.info(String.format("[INFO:] 'Add to Car Park' button by index=%d was clicked", index));
        return new BenefitsPopupComponent(driver);
    }

    public HomePage clickGoBackButtonToCarPark() {
        goBackButton.click();
        REPORT.info("[INFO:] 'Go back' button was clicked");
        return new HomePage(driver);
    }
}
