package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Android 'mobile.de' app testing")
@Feature("Product cards testing")
public class AndroidTest extends BaseTest {

    @Test
    @Story("Cards testing")
    @Description("Verifying something test")
    public void exampleTest() {

    }
}
