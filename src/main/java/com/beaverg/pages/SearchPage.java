package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.components.popup.SaveSearchPopupComponent;
import com.beaverg.components.popup.search_popups.ConditionPopupComponent;
import com.beaverg.components.popup.search_popups.MakePopupComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text='Search']")
    private WebElement title;

    @FindBy(id = "btn_select")
    private WebElement modelItem;

    @FindBy(xpath = "//android.widget.TextView[@text='Condition']")
    private WebElement conditionItem;

    @FindBy(id = "show_results")
    private WebElement showResultsButton;

    public SearchPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        REPORT.info("[INFO:] Checking opening Search page");
        return title.isDisplayed();
    }

    public MakePopupComponent clickModelItem() {
        modelItem.click();
        REPORT.info("[INFO:] 'Model' item was clicked");
        return new MakePopupComponent(driver);
    }

    public ConditionPopupComponent clickConditionItem() {
        conditionItem.click();
        REPORT.info("[INFO:] 'Condition' item was clicked");
        return new ConditionPopupComponent(driver);
    }

    public SaveSearchPopupComponent clickShowResultsButton() {
        showResultsButton.click();
        REPORT.info("[INFO:] 'Show results' button was clicked");
        return new SaveSearchPopupComponent(driver);
    }
}
