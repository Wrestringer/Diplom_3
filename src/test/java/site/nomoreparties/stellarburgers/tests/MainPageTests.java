package site.nomoreparties.stellarburgers.tests;

import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.pom.MainPage;


public class MainPageTests extends BaseTest {

    @Test
    public void clickAllPositionTest() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();

        mainPage.clickSpanFilling().checkH2FillingAppears();
        mainPage.clickSpanSauce().checkH2SauceAppears();
        mainPage.clickSpanBun().checkH2BunAppears();
    }

}
