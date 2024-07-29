package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.pom.AccountProfilePage;
import site.nomoreparties.stellarburgers.pom.LogInPage;
import site.nomoreparties.stellarburgers.pom.MainPage;


public class AccountProfileTests extends BaseTest {
    
    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет».")
    @Description("Проверка открытия личного кабинета по клику на кнопку «Личный кабинет»")
    public void goToAccountProfileFromMainTest() {
        LogInPage logInPage = new LogInPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(webDriver);


        logInPage.open()
                .checkH2LabelLogInDisplayed()
                .fillLogInForm(user.getEmail(), user.getPassword())
                .clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed().clickAPersonalAccount();

        accountProfilePage.checkLabelAProfileDisplayed();

    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор».")
    @Description("Проверка перехода по клику на «Конструктор» из Личного Кабинета")
    public void goToConstructorFromAccountProfileWithPConstructorTest() {
        LogInPage logInPage = new LogInPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(webDriver);


        logInPage.open()
                .checkH2LabelLogInDisplayed()
                .fillLogInForm(user.getEmail(), user.getPassword())
                .clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed().clickAPersonalAccount();

        accountProfilePage.checkLabelAProfileDisplayed().clickLabelPConstructor();

        mainPage.checkButtonCreateOrderDisplayed();

    }


    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор».")
    @Description("Проверка перехода по клику на логотип Stellar Burgers из Личного Кабинета")
    public void goToConstructorFromAccountProfileWithDivLogoTest() {
        LogInPage logInPage = new LogInPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(webDriver);


        logInPage.open()
                .checkH2LabelLogInDisplayed()
                .fillLogInForm(user.getEmail(), user.getPassword())
                .clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed().clickAPersonalAccount();

        accountProfilePage.checkLabelAProfileDisplayed().clickDivLogo();

        mainPage.checkButtonCreateOrderDisplayed();

    }


    @Test
    @DisplayName("Проверка выхода из системы")
    @Description("Проверка выхода из системы по кнопке «Выйти» из Личного Кабинета")
    public void logOutTest() {
        LogInPage logInPage = new LogInPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(webDriver);


        logInPage.open()
                .checkH2LabelLogInDisplayed()
                .fillLogInForm(user.getEmail(), user.getPassword())
                .clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed().clickAPersonalAccount();

        accountProfilePage.checkLabelAProfileDisplayed().clickButtonLogOut();

        logInPage.checkH2LabelLogInDisplayed();

    }

}
