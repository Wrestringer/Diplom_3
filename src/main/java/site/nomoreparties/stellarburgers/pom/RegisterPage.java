package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;

public class RegisterPage {

    private static final String URL = STELLARBURGERS_NOMOREPARTIES_PROD + "register";

    private final WebDriver webDriver;

    private final By inputName =  By.xpath(".//label[text()='Имя']/parent::div/input");
    private final By inputEmail =  By.xpath(".//label[text()='Email']/parent::div/input");
    private final By inputPassword =  By.xpath(".//input[@name='Пароль']");
    private final By buttonRegister =  By.xpath(".//button[text()='Зарегистрироваться']");
    private final By pIncorrectPassword =  By.xpath(".//p[text()='Некорректный пароль']");

    private final By aLogIn =  By.xpath(".//a[@href='/login']");

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открыть страницу реистрации")
    public RegisterPage open() {
        webDriver.get(URL);
        return this;
    }

    public void fillInput(By elementInput, String value) {
        WebElement element = webDriver.findElement(elementInput);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(elementInput).sendKeys(value);
    }

    @Step("Заполнить данные регистрации")
    public RegisterPage fillRegisteredForm(String name, String email, String password) {
        fillInput(inputName, name);
        fillInput(inputEmail, email);
        fillInput(inputPassword, password);
        return this;
    }

    @Step("Нажать на кнопку регистрации")
    public RegisterPage clickButtonRegister() {
        webDriver.findElement(buttonRegister).click();
        return this;
    }

    @Step("Нажать на кнопку входа")
    public RegisterPage clickALogIn() {
        webDriver.findElement(aLogIn).click();
        return this;
    }

    @Step("Проверка ввода пароля меньше 6 символов")
    public RegisterPage checkInvalidPasswordMessageAppears() {
        assertTrue("Сообщения о некорректном пароле нет",webDriver.findElement(pIncorrectPassword).isDisplayed());
        return this;
    }

}
