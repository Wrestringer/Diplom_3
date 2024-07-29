package site.nomoreparties.stellarburgers.tests;


import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.pom.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pom.LogInPage;
import site.nomoreparties.stellarburgers.pom.MainPage;
import site.nomoreparties.stellarburgers.pom.RegisterPage;


public class LogInTests extends BaseTest {

    private static final String EMAIL_OF_USER = "mhdgsha32eror@opi.oi";
    private static final String PASSWORD_OF_USER = "asf3455";


    @Test
    public void logInFromMainWithLabelAPersonalAccountTest() {
        MainPage mainPage = new MainPage(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);

        mainPage.open().clickAPersonalAccount();

        logInPage.checkH2LabelLogInDisplayed().fillLogInForm(user.getEmail(), user.getPassword()).clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed();

    }


    @Test
    public void logInFromMainWithButtonLogInTest() {
        MainPage mainPage = new MainPage(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);

        mainPage.open().clickButtonLogIn();

        logInPage.checkH2LabelLogInDisplayed().fillLogInForm(user.getEmail(), user.getPassword()).clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed();

    }


    @Test
    public void logInFromRegisterFormWithLabelALogInTest() {
        RegisterPage registerPage = new RegisterPage(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);

        registerPage.open().clickALogIn();

        logInPage.checkH2LabelLogInDisplayed().fillLogInForm(user.getEmail(), user.getPassword()).clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed();

    }


    @Test
    public void logInFromForgotPasswordFormWithLabelALogInTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);

        forgotPasswordPage.open().clickALogIn();

        logInPage.checkH2LabelLogInDisplayed().fillLogInForm(user.getEmail(), user.getPassword()).clickButtonLogIn();

        mainPage.checkButtonCreateOrderDisplayed();

    }

}
