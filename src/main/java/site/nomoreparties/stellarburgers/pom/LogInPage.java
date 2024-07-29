package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;

public class LogInPage {

    private static final String URL = STELLARBURGERS_NOMOREPARTIES_PROD + "login";

    private final WebDriver webDriver;

    private final By h2LogIn =  By.xpath(".//h2[text()='Вход']");

    private final By inputEmail =  By.xpath(".//label[text()='Email']/parent::div/input");
    private final By inputPassword =  By.xpath(".//input[@name='Пароль']");

    private final By buttonLogIn =  By.xpath(".//button[text()='Войти']");

    public LogInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Step("Открыть страницу входа")
    public LogInPage open() {
        webDriver.get(URL);
        return this;
    }

    @Step("Проверка открытия страницы входа")
    public LogInPage checkH2LabelLogInDisplayed() {
        assertTrue("h2 'Вход' не отображается",webDriver.findElement(h2LogIn).isDisplayed());
        return this;
    }

    public void fillInput(By elementInput, String value) {
        WebElement element = webDriver.findElement(elementInput);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(elementInput).sendKeys(value);
    }

    @Step("Заполнить данные входа")
    public LogInPage fillLogInForm(String email, String password) {
        fillInput(inputEmail, email);
        fillInput(inputPassword, password);
        return this;
    }

    @Step("Нажать на кнопку входа")
    public LogInPage clickButtonLogIn() {
        webDriver.findElement(buttonLogIn).click();
        return this;
    }


}
