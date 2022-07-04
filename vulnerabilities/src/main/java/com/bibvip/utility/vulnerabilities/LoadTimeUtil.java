package com.bibvip.utility.vulnerabilities;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.bibvip.config.DriverConfig.driver;
import static com.bibvip.consts.BaseURL.PROD_BASE_URL;
import static com.bibvip.consts.ElementType.*;
import static com.bibvip.utility.vulnerabilities.ThinkingTimeUtil.getBy;
import static com.bibvip.utility.vulnerabilities.ThinkingTimeUtil.getElementWithPolling;

@Slf4j
public class LoadTimeUtil {

    static long start;
    static long finish;
    static long totalTime;

    //WebDriver getLoadTime
    public static WebDriver getLoadTime(String baseURL) throws TimeoutException {
        start = System.currentTimeMillis();
        driver.get(baseURL);
        driver.manage().window().maximize();
        //javascript executor to check page ready state
        JavascriptExecutor j = (JavascriptExecutor) driver;
        if(j.executeScript("return document.readyState").toString().equals("complete")){
            log.info("Page loaded properly");
        }
        finish = System.currentTimeMillis();
        totalTime = finish - start;
        log.info("Browser Finished Loading in millis: "+totalTime);
        exceedExpectedLoadTime(totalTime);
        return driver;
    }

    //WebElement getLoadTime
    public static WebElement getLoadTime(WebDriverWait wait, String url, ElementType type) throws TimeoutException {
        start = System.currentTimeMillis();
        WebElement element = getElementWithPolling(wait, getBy(url, type));
        finish = System.currentTimeMillis();
        totalTime = finish - start;
        //can be converted to seconds totalTime = (finish - start) / 1000
//        element.click();
        log.info("Total time to finish loading ("+element.getText()+") part in millis: "+totalTime);
        exceedExpectedLoadTime(totalTime);
        return element;
    }

    //WebElement with iFrame getLoadTime
    public static WebElement getLoadTime(WebDriverWait wait, String iframePath, String url, ElementType type) throws TimeoutException {
        start = System.currentTimeMillis();
        //iframe setup
        WebElement iframe = getElementWithPolling(wait, getBy(iframePath, TAG_NAME)); //Solution to my problem <3
        driver.switchTo().frame(iframe);

        //START element actions
        WebElement element = getElementWithPolling(wait, getBy(url, type));
        element.click();
        String elementStr = String.valueOf(element.isDisplayed());
        log.info("Chart Types options appeared? " + elementStr);
        //END element actions

        finish = System.currentTimeMillis();
        totalTime = finish - start;
        log.info("Total time to finish loading ("+element.getText()+") part in millis: "+totalTime);

        //switch to default setup
        driver.switchTo().defaultContent();
        exceedExpectedLoadTime(totalTime);
        return element;
    }

    //WebElement javassxcrftgyhuji getLoadTime
    public static WebElement getLoadTime(WebDriverWait wait, JavascriptExecutor j, String iframePath, String url, ElementType type) throws TimeoutException {
        start = System.currentTimeMillis();
        //WebElement element = getElementWithPolling(wait, getBy(url, type));

        //Javascript
        j = (JavascriptExecutor) driver;
        j.executeScript("document.querySelector('" + url + "').click();");

        //iFrame
        WebElement iframe = driver.findElement(getBy(iframePath, TAG_NAME)); //Solution to my problem <3
        driver.switchTo().frame(iframe);

        WebElement element = getElementWithPolling(wait, getBy(url, type));
        element.click();
        //switch back content from iframe to default
        driver.switchTo().defaultContent();

        finish = System.currentTimeMillis();
        totalTime = finish - start;
        log.info("Total time to finish loading ("+element.getText()+") part in millis: "+totalTime);
        exceedExpectedLoadTime(totalTime);
        return element;
    }

    public static void exceedExpectedLoadTime(long totalTime) throws TimeoutException {
        if (totalTime < 10000) {
            log.info("Loading of this part is properly handled.");
        } else {
            log.error("The loading of this part needs improvement! Exceeds 10s");
            throw new TimeoutException();
        }
    }

}
