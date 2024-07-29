package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;

public class MainPage {

    private static final String URL = STELLARBURGERS_NOMOREPARTIES_PROD;

    private final WebDriver webDriver;

    private final By buttonLogIn =  By.xpath(".//button[text()='Войти в аккаунт']");
    private final By aPersonalAccount =  By.xpath(".//a[@href='/account']");
    private final By buttonCreateOrder =  By.xpath(".//button[text()='Оформить заказ']");

    private final By spanBun =  By.xpath(".//span[text()='Булки']/parent::div");
    private final By spanSauce =  By.xpath(".//span[text()='Соусы']/parent::div");
    private final By spanFilling =  By.xpath(".//span[text()='Начинки']/parent::div");

    private final By h2Bun =  By.xpath(".//h2[text()='Булки']");
    private final By h2Sauce =  By.xpath(".//h2[text()='Соусы']");
    private final By h2Filling =  By.xpath(".//h2[text()='Начинки']");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открыть главную страницу")
    public MainPage open() {
        webDriver.get(URL);
        return this;
    }

    @Step("Нажать на кнопку входа")
    public MainPage clickButtonLogIn() {
        webDriver.findElement(buttonLogIn).click();
        return this;
    }

    @Step("Нажать на кнпоку Личный кабинет")
    public MainPage clickAPersonalAccount() {
        webDriver.findElement(aPersonalAccount).click();
        return this;
    }

    @Step("Проверка успешной авторизации")
    public MainPage checkButtonCreateOrderDisplayed() {
        assertTrue("button 'Оформить заказ' не отображается", webDriver.findElement(buttonCreateOrder).isDisplayed());
        return this;
    }


    @Step("Выбрать Булки")
    public MainPage clickSpanBun() {
        WebElement element = webDriver.findElement(spanBun);
        JavascriptExecutor ex=(JavascriptExecutor)webDriver;
        ex.executeScript("arguments[0].click()", element);
        return this;
    }

    @Step("Выбрать соус")
    public MainPage clickSpanSauce() {
        webDriver.findElement(spanSauce).click();
        return this;
    }

    @Step("Выбрать Начинки")
    public MainPage clickSpanFilling() {
        webDriver.findElement(spanFilling).click();
        return this;
    }

    @Step("Проверка отображения булок")
    public MainPage checkH2BunAppears() {
        assertTrue("h2 'Булки' не отображается", webDriver.findElement(h2Bun).isDisplayed());
        return this;
    }

    @Step("Проверка отображения соусов")
    public MainPage checkH2SauceAppears() {
        assertTrue("h2 'Соусы' не отображается", webDriver.findElement(h2Sauce).isDisplayed());
        return this;
    }

    @Step("Проверка отображения начинок")
    public MainPage checkH2FillingAppears() {
        assertTrue("h2 'Начинки' не отображается", webDriver.findElement(h2Filling).isDisplayed());
        return this;
    }

}
