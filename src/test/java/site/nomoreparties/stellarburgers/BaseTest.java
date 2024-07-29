package site.nomoreparties.stellarburgers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.models.RegisteredUser;
import site.nomoreparties.stellarburgers.models.User;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static site.nomoreparties.stellarburgers.api.UserMethods.sendDeleteUserRequest;
import static site.nomoreparties.stellarburgers.api.UserMethods.sendPostRequestToCreateUser;
import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.utils.Utils.randomString;

public class BaseTest {

    private static final String RANDOM_NAME_OF_USER = randomString();
    private static final String RANDOM_EMAIL_OF_USER = randomString() + "@ya.ru";
    private static final String RANDOM_PASSWORD_OF_USER = randomString();

    protected WebDriver webDriver;

    protected User user;
    protected RegisteredUser registeredUser;



    @Before
    public void setup() {
        RestAssured.baseURI= STELLARBURGERS_NOMOREPARTIES_PROD;

        user = new User(RANDOM_EMAIL_OF_USER, RANDOM_NAME_OF_USER, RANDOM_PASSWORD_OF_USER);
        Response response = sendPostRequestToCreateUser(user);
        registeredUser = response.as(RegisteredUser.class);

        webDriver = createWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    @After
    public void tearDown() {
        webDriver.quit();
        sendDeleteUserRequest(user, registeredUser.getAccessToken());
    }

}
