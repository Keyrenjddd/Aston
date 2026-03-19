package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsMainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By cookieAcceptButton = By.xpath("//*[@id=\"cookie-agree\"]");
    private By phoneInput = By.xpath("//input[@placeholder='Номер телефона']");
    private By sumInput = By.xpath("//input[@placeholder='Сумма']");
    private By emailInput = By.xpath("//input[@placeholder='E-mail для отправки чека']");
    private By continueButton = By.xpath("//button[contains(text(),'Продолжить')]");

    public MtsMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void acceptCookies() {
        try {
            WebElement accept = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            accept.click();
        } catch (TimeoutException e) {
        }
    }

    public String getPhonePlaceholder() {
        WebElement field = driver.findElement(phoneInput);
        return field.getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        WebElement field = driver.findElement(sumInput);
        return field.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        WebElement field = driver.findElement(emailInput);
        return field.getAttribute("placeholder");
    }

    public void fillPhone(String phone) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        field.clear();
        field.sendKeys(phone);
    }

    public void fillSum(String sum) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput));
        field.clear();
        field.sendKeys(sum);
    }

    public void fillEmail(String email) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        field.clear();
        field.sendKeys(email);
    }

    public void clickContinue() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();
    }

    public boolean isPaymentFramePresent() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}