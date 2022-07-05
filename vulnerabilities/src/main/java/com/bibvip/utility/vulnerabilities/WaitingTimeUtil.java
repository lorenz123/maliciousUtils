package com.bibvip.utility.vulnerabilities;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This utility class has 2 methods getElementWithPolling, uses a visibilityElementLocated function
 * where has a 1sec polling and 40secs waiting time,
 * the other method is getWebDriverWait, which waits for the driver before returning it to be used.
 */
@Slf4j
public class WaitingTimeUtil {

    public static final Integer WAITING_TIME = 40;
    public static final Integer POLLING_TIME = 1;

    static WebElement element;
    static WebDriverWait wait;

    public static WebElement getElementWithPolling(WebDriverWait wait, By webElementBy) {

        wait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
        return element;
    }

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME));
        return wait;
    }


}
