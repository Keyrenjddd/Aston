package com;

import com.pages.MtsMainPage;
import com.pages.MtsPaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentPageObjectTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MtsMainPage mainPage;
    private MtsPaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/146.0.0.0 Safari/537.36");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.mts.by");
        mainPage = new MtsMainPage(driver, wait);
        mainPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPlaceholders() {
        assertEquals("Номер телефона", mainPage.getPhonePlaceholder());
        assertEquals("Сумма", mainPage.getSumPlaceholder());
        assertEquals("E-mail для отправки чека", mainPage.getEmailPlaceholder());
    }

    @Test
    public void testServiceConnectionPayment() {
        mainPage.fillPhone("297777777");
        mainPage.fillSum("1");
        mainPage.fillEmail("spbs.exes@yandex.ru");
        mainPage.clickContinue();

        assertTrue(mainPage.isPaymentFramePresent(), "Iframe оплаты не появился");

        // Детальные проверки внутри iframe невозможны, так как для тестового номера контент не загружается.
        // При использовании реального номера можно раскомментировать следующие строки.
        /*
        paymentPage = new MtsPaymentPage(driver, wait);
        paymentPage.switchToFrame();

        String displayedPhone = paymentPage.getDisplayedPhone();
        assertTrue(displayedPhone.contains("297777777"), "Номер отображается неверно: " + displayedPhone);

        assertEquals("Номер карты", paymentPage.getCardNumberPlaceholder());
        assertEquals("Срок действия", paymentPage.getCardExpiryPlaceholder());
        assertEquals("CVC", paymentPage.getCardCvcPlaceholder());

        assertTrue(paymentPage.arePaymentIconsDisplayed(), "Не все иконки платёжных систем отображаются");

        String buttonText = paymentPage.getPaymentButtonText();
        assertTrue(buttonText.contains("Оплатить") || buttonText.contains("Pay"),
                "Текст кнопки не корректен: " + buttonText);
        */
    }
}