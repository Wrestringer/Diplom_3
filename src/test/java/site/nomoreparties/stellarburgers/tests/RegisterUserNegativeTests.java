package site.nomoreparties.stellarburgers.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.pom.RegisterPage;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.utils.Utils.randomString;

public class RegisterUserNegativeTests extends BaseTest {

    private static final String RANDOM_NAME_OF_USER = randomString();
    private static final String RANDOM_EMAIL_OF_USER = randomString() + "@ya.ru";

    @Before
    public void setup() {
        webDriver = createWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
    }

    @Test
    public void registerUserTooShortPasswordTest() {
        RegisterPage registerPage = new RegisterPage(webDriver);

        registerPage.open()
                .fillRegisteredForm(RANDOM_NAME_OF_USER, RANDOM_EMAIL_OF_USER, randomString(5))
                .clickButtonRegister()
                .checkInvalidPasswordMessageAppears();

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
