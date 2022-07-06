package com.bibvip.utility.vulnerabilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

import static com.bibvip.config.DriverConfig.driver;
import static com.bibvip.utility.vulnerabilities.ExceedLoadTimeUtil.exceedExpectedLoadTime;

/**
 * This utility class will check the load time of the selected page/url
 */
@Slf4j
public class PageLoadTimeUtil {


    public static WebDriver getPageLoadTime(String baseURL) throws TimeoutException {
        long start = System.currentTimeMillis();
        driver.get(baseURL);
        driver.manage().window().maximize();
        JavascriptExecutor j = (JavascriptExecutor) driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")) {
            log.info("Page loaded properly");
        }
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        log.info("Browser Finished Loading in millis: " + totalTime);
        exceedExpectedLoadTime(totalTime);
        return driver;
    }

}
