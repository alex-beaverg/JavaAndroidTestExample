package com.beaverg.pages;

import com.beaverg.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchAutoCardPage extends BasePage {
    @FindBy(id = "phone_v1")
    private WebElement elementForChecking;

    @FindBy(id = "make_title")
    private WebElement title1;

    @FindBy(id = "model_title")
    private WebElement title2;

    @FindBy(id = "price_v1")
    private WebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text='First Registration']//following-sibling::android.widget.TextView")
    private WebElement firstRegistration;

    @FindBy(xpath = "//android.widget.TextView[@text='Mileage']//following-sibling::android.widget.TextView")
    private WebElement mileage;

    @FindBy(xpath = "//android.widget.TextView[@text='Power']//following-sibling::android.widget.TextView")
    private WebElement performance;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Park']")
    private WebElement carParkButton;

    public SearchAutoCardPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening Auto Card page");
        return elementForChecking.isDisplayed();
    }

    public String getTitle() {
        REPORT.info("[INFO:] Getting Auto Card title");
        return title1.getText() + " " + title2.getText();
    }

    public int getPrice() {
        REPORT.info("[INFO:] Getting Auto Card price");
        return Integer.parseInt(price.getText()
                .replace("€", "")
                .replace(",", "").strip());
    }

    public String getFirstRegistration(double percentage) {
        swipeToText("kW", percentage);
        REPORT.info("[INFO:] Getting Auto Card first registration");
        return firstRegistration.getText();
    }

    public int getMileage() {
        REPORT.info("[INFO:] Getting Auto Card mileage");
        return Integer.parseInt(mileage.getText()
                .replace("\u00a0km", "")
                .replace(",", ""));
    }

    public String getPerformance() {
        REPORT.info("[INFO:] Getting Auto Card performance");
        return performance.getText().replace("\u00a0", " ");
    }

    public void clickCarParkButton() {
        carParkButton.click();
        REPORT.info("[INFO:] 'Car Park' button was clicked");
    }
}
