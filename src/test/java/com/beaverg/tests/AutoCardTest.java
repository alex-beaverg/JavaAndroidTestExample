package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.components.drop.MenuDropComponent;
import com.beaverg.domain.AutoCard;
import com.beaverg.pages.AutoCardPage;
import com.beaverg.pages.HomePage;
import com.beaverg.pages.OnlineBuyingPage;
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
        OnlineBuyingPage onlineBuyingPage = menuDropComponent
                .clickOnlineBuyingItem()
                .clickComponentBody();
        sa.assertTrue(onlineBuyingPage.isPageOpen(), "Online Buying page isn't open!");

        int cardNumber = Integer.parseInt(PropertyGetter.getData("card_number"));
        AutoCard onlineBuyingAutoCard = AutoCardService.createOnlineBuyingAutoCardByIndex(onlineBuyingPage, cardNumber);

        AutoCardPage autoCardPage = onlineBuyingPage.clickAutoCardByIndex(cardNumber);
        sa.assertTrue(autoCardPage.isPageOpen(), "AutoCard page isn't open!");

        AutoCard autoCard = AutoCardService.createAutoCard(autoCardPage);
        sa.assertEquals(onlineBuyingAutoCard, autoCard, "Objects aren't equal!");

        sa.assertAll();
    }
}
