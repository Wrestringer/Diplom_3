package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;

public class AccountProfilePage {

    private static final String URL = STELLARBURGERS_NOMOREPARTIES_PROD + "account/profile";

    private final WebDriver webDriver;

    private final By aProfile =  By.xpath(".//a[text()='Профиль']");
    private final By pConstructor =  By.xpath(".//p[text()='Конструктор']");
    private final By divLogo =  By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By buttonLogOut =  By.xpath(".//button[text()='Выход']");

    public AccountProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открыть страницу Личный кабинет")
    public AccountProfilePage open() {
        webDriver.get(URL);
        return this;
    }

    @Step("Проверка перехода в Личный кабинет ")
    public AccountProfilePage checkLabelAProfileDisplayed() {
        assertTrue("a 'Личный кабинет' не отображается",webDriver.findElement(aProfile).isDisplayed());
        return this;
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public AccountProfilePage clickLabelPConstructor() {
        webDriver.findElement(pConstructor).click();
        return this;
    }

    @Step("Нажать на логотип Stellar Burgers")
    public AccountProfilePage clickDivLogo() {
        webDriver.findElement(divLogo).click();
        return this;
    }

    @Step("Нажать на кнопку 'Выйти'")
    public AccountProfilePage clickButtonLogOut() {
        webDriver.findElement(buttonLogOut).click();
        return this;
    }

}
