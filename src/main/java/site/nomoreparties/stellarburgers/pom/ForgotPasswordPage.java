package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;

public class ForgotPasswordPage {

    private static final String URL = STELLARBURGERS_NOMOREPARTIES_PROD + "forgot-password";

    private final WebDriver webDriver;

    private final By aLogIn =  By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открыть страницу восстановления пароля")
    public ForgotPasswordPage open() {
        webDriver.get(URL);
        return this;
    }

    @Step("Нажать ссылку 'Войти'")
    public ForgotPasswordPage clickALogIn() {
        webDriver.findElement(aLogIn).click();
        return this;
    }

}
