package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.components.drop.MenuDropComponent;
import com.beaverg.components.popup.BenefitsPopupComponent;
import com.beaverg.components.popup.SaveSearchPopupComponent;
import com.beaverg.components.popup.search_popups.ConditionPopupComponent;
import com.beaverg.components.popup.search_popups.MakePopupComponent;
import com.beaverg.components.popup.search_popups.ModelPopupComponent;
import com.beaverg.domain.AutoCard;
import com.beaverg.pages.*;
import com.beaverg.utils.AutoCardService;
import com.beaverg.utils.PropertyGetter;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Android 'mobile.de' app testing")
@Feature("Auto cards testing")
public class AutoCardTest extends BaseTest {

    @Test
    @Description("Verifying Online Buying auto card test")
    public void onlineBuyingCardTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();
        MenuDropComponent menuDropComponent = homePage.clickOpenMenuButton();
        sa.assertTrue(menuDropComponent.isComponentOpen(), "Menu drop component isn't open!");

        SaveSearchPopupComponent saveSearchPopupComponent = menuDropComponent.clickOnlineBuyingItem();
        sa.assertTrue(saveSearchPopupComponent.isComponentOpen(), "Save Search popup component isn't open!");

        AutoCardsPage autoCardsPage = saveSearchPopupComponent.clickSaveSearchButton();
        sa.assertTrue(autoCardsPage.isPageOpen(), "Auto Cards page isn't open!");

        int cardNumber = Integer.parseInt(PropertyGetter.getData("card_number"));
        AutoCard autoCardFromList = AutoCardService.createAutoCardByIndex(autoCardsPage, cardNumber);
        OnlineBuyingAutoCardPage autoCardPage = autoCardsPage.clickOnlineBuyingAutoCardByIndex(cardNumber);
        sa.assertTrue(autoCardPage.isPageOpen(), "Auto Card page isn't open!");

        AutoCard autoCard = AutoCardService.createOnlineBuyingAutoCard(autoCardPage);
        sa.assertEquals(autoCardFromList, autoCard, "Objects aren't equal!");

        sa.assertAll();
    }

    @Test
    @Description("Verifying auto card after search test")
    public void searchCardTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();
        MenuDropComponent menuDropComponent = homePage.clickOpenMenuButton();
        SearchPage searchPage = menuDropComponent.clickSearchItem();
        sa.assertTrue(searchPage.isPageOpen(), "Search page isn't open!");

        MakePopupComponent makePopupComponent = searchPage.clickModelItem();
        sa.assertTrue(makePopupComponent.isComponentOpen(), "Make popup component isn't open!");

        ModelPopupComponent modelPopupComponent = makePopupComponent.clickMitsubishiItem();
        sa.assertTrue(modelPopupComponent.isComponentOpen(), "Model popup component isn't open!");

        modelPopupComponent.clickLancerItemCheckBox();
        searchPage = modelPopupComponent.clickOkButton();
        sa.assertTrue(searchPage.isPageOpen(), "Search page isn't open!");

        ConditionPopupComponent conditionPopupComponent = searchPage.clickConditionItem();
        sa.assertTrue(conditionPopupComponent.isComponentOpen(), "Condition popup component isn't open!");

        searchPage = conditionPopupComponent.clickUsedRadioButton();
        sa.assertTrue(searchPage.isPageOpen(), "Search page isn't open!");

        SaveSearchPopupComponent saveSearchPopupComponent = searchPage.clickShowResultsButton();
        sa.assertTrue(saveSearchPopupComponent.isComponentOpen(), "Save Search popup component isn't open!");

        AutoCardsPage autoCardsPage = saveSearchPopupComponent.clickSaveSearchButton();
        sa.assertTrue(autoCardsPage.isPageOpen(), "Auto Cards page isn't open!");

        int cardNumber = Integer.parseInt(PropertyGetter.getData("card_number"));

        AutoCard autoCardFromList = AutoCardService.createAutoCardByIndex(autoCardsPage, cardNumber);
        SearchAutoCardPage autoCardPage = autoCardsPage.clickSearchAutoCardByIndex(cardNumber);
        sa.assertTrue(autoCardPage.isPageOpen(), "Auto Card page isn't open!");

        AutoCard autoCard = AutoCardService.createSearchAutoCard(autoCardPage, 0.35);
        sa.assertEquals(autoCardFromList, autoCard, "Objects aren't equal!");

        sa.assertAll();
    }

    @Test
    @Description("Verifying Car Parking auto card test")
    public void carParkingCardTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();
        MenuDropComponent menuDropComponent = homePage.clickOpenMenuButton();
        sa.assertTrue(menuDropComponent.isComponentOpen(), "Menu drop component isn't open!");

        SaveSearchPopupComponent saveSearchPopupComponent = menuDropComponent.clickOnlineBuyingItem();
        sa.assertTrue(saveSearchPopupComponent.isComponentOpen(), "Save Search popup component isn't open!");

        AutoCardsPage autoCardsPage = saveSearchPopupComponent.clickSaveSearchButton();
        sa.assertTrue(autoCardsPage.isPageOpen(), "Auto Cards page isn't open!");

        int cardNumber = Integer.parseInt(PropertyGetter.getData("card_number"));
        AutoCard autoCardFromList = AutoCardService.createAutoCardByIndex(autoCardsPage, cardNumber);
        BenefitsPopupComponent benefitsPopupComponent = autoCardsPage.clickAddToCarParkButtonByIndex(cardNumber);
        benefitsPopupComponent.clickCancelButton();
        homePage = autoCardsPage.clickGoBackButtonToCarPark();
        sa.assertTrue(homePage.isPageOpen(), "Home page isn't open!");

        menuDropComponent = homePage.clickOpenMenuButton();
        sa.assertTrue(menuDropComponent.isComponentOpen(), "Menu drop component isn't open!");

        CarParkPage carParkPage = menuDropComponent.clickCarParkItem();
        sa.assertTrue(carParkPage.isPageOpen(), "Car Park page isn't open!");

        AutoCard carParkAutoCard = AutoCardService.createAutoCardByIndex(carParkPage, 0);
        sa.assertEquals(autoCardFromList, carParkAutoCard, "Objects aren't equal!");

        SearchAutoCardPage autoCardPage = carParkPage.clickSearchAutoCardByIndex(0);
        AutoCard autoCard = AutoCardService.createSearchAutoCard(autoCardPage, 0.35);
        sa.assertEquals(carParkAutoCard, autoCard, "Objects aren't equal!");

        autoCardPage.clickCarParkButton();

        sa.assertAll();
    }
}
