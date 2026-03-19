package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsPaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By sumDisplay = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/div[2]/span");
    private By phoneDisplay = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");
    private By cardNumberField = By.xpath("//*[@id=\"cc-number\"]");
    private By cardExpiryField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/input");
    private By cardCvcField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input");
    private By cardHolderField = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/input");
    private By paymentButton = By.xpath("//button[contains(text(),'Оплатить')]");


    private By sumByText = By.xpath("//*[contains(text(),'1.00') or contains(text(),'1') and contains(@class,'sum')]");
    private By phoneByText = By.xpath("//*[contains(text(),'297777777')]");
    private By cardNumberByPlaceholder = By.xpath("//input[contains(@placeholder,'Номер карты')]");
    private By cardExpiryByPlaceholder = By.xpath("//input[contains(@placeholder,'Срок') or contains(@placeholder,'MM/YY')]");
    private By cardCvcByPlaceholder = By.xpath("//input[contains(@placeholder,'CVC') or contains(@placeholder,'CVV')]");


    private By visaIcon = By.xpath("//img[contains(@alt,'visa')]");
    private By mastercardIcon = By.xpath("//img[contains(@alt,'mastercard')]");
    private By belkartIcon = By.xpath("//img[contains(@alt,'белкарт')]");

    public MtsPaymentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void switchToFrame() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
        driver.switchTo().frame(iframe);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String pageSource = driver.getPageSource();
        System.out.println("===== Содержимое iframe (первые 500 символов) =====");
        System.out.println(pageSource.substring(0, Math.min(500, pageSource.length())));
        System.out.println("===================================================");

        if (driver.findElements(By.xpath("./*")).isEmpty()) {
            throw new TimeoutException("Iframe пуст! Загрузка контента не произошла. Возможно, сайт блокирует автоматизацию.");
        }
    }

    public String getDisplayedSum() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sumDisplay));
            return element.getText().trim();
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти сумму по точному локатору. Пробуем по тексту...");
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sumByText));
            return element.getText().trim();
        }
    }

    public String getDisplayedPhone() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneDisplay));
            return element.getText().trim();
        } catch (TimeoutException e) {
            System.out.println("Не удалось найти номер по точному локатору. Пробуем по тексту...");
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneByText));
            return element.getText().trim();
        }
    }

    public String getCardNumberPlaceholder() {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField));
            return field.getAttribute("placeholder");
        } catch (TimeoutException e) {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberByPlaceholder));
            return field.getAttribute("placeholder");
        }
    }

    public String getCardExpiryPlaceholder() {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryField));
            return field.getAttribute("placeholder");
        } catch (TimeoutException e) {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiryByPlaceholder));
            return field.getAttribute("placeholder");
        }
    }

    public String getCardCvcPlaceholder() {
        try {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcField));
            return field.getAttribute("placeholder");
        } catch (TimeoutException e) {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcByPlaceholder));
            return field.getAttribute("placeholder");
        }
    }

    public boolean arePaymentIconsDisplayed() {
        boolean visa = driver.findElements(visaIcon).size() > 0;
        boolean master = driver.findElements(mastercardIcon).size() > 0;
        boolean belkart = driver.findElements(belkartIcon).size() > 0;
        return visa && master && belkart;
    }

    public String getPaymentButtonText() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButton));
        return button.getText().trim();
    }
}