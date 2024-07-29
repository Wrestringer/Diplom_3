package site.nomoreparties.stellarburgers.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.models.RegisteredUser;
import site.nomoreparties.stellarburgers.models.User;
import site.nomoreparties.stellarburgers.pom.LogInPage;
import site.nomoreparties.stellarburgers.pom.RegisterPage;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static site.nomoreparties.stellarburgers.api.UserMethods.sendDeleteUserRequest;
import static site.nomoreparties.stellarburgers.api.UserMethods.sendPostRequestToLogInUser;
import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.utils.Utils.randomString;


public class RegisterPositiveTests extends BaseTest {

    private static final String RANDOM_NAME_OF_USER = randomString();
    private static final String RANDOM_EMAIL_OF_USER = randomString() + "@ya.ru";
    private static final String RANDOM_PASSWORD_OF_USER = randomString();


    @Before
    public void setup() {
        RestAssured.baseURI= STELLARBURGERS_NOMOREPARTIES_PROD;
        user = new User(RANDOM_EMAIL_OF_USER, RANDOM_NAME_OF_USER, RANDOM_PASSWORD_OF_USER);

        webDriver = createWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }


    @Test
    public void registerPositiveUserTest() {
        RegisterPage registerPage = new RegisterPage(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);

        registerPage.open().fillRegisteredForm(user.getName(), user.getEmail(), user.getPassword()).clickButtonRegister();

        logInPage.checkH2LabelLogInDisplayed();
    }


    @After
    public void tearDown() {
        webDriver.quit();

        Response response = sendPostRequestToLogInUser(user);
        registeredUser = response.as(RegisteredUser.class);
        sendDeleteUserRequest(user, registeredUser.getAccessToken());
    }

}
