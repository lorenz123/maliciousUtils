package com.bibvip.utility.vulnerabilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.bibvip.utility.vulnerabilities.ExceedLoadTimeUtil.exceedExpectedLoadTime;

/**
 * This utility class will get all the links inside a page and check the status code (200 or 404)
 */
@Slf4j
public class PageLinksErrorUtil {
    private static long start;
    private static long finish;
    private static long totalTime;

    public static void checkPageLinksForErrors(WebDriver driver) throws TimeoutException, IOException {

        List<WebElement> l = driver.findElements(By.tagName("a"));

        try {
            for (int j = 0; j < l.size(); j++) {

                WebElement e = l.get(j);
                String links = e.getAttribute("href");
                URL link = new URL(links);

                start = System.currentTimeMillis();
                HttpURLConnection connection = (HttpURLConnection) link.openConnection();
                finish = System.currentTimeMillis();
                totalTime = finish - start;
                log.info("Loading per each get: " + totalTime);
                exceedExpectedLoadTime(totalTime);
                connection.setConnectTimeout(2000);
                connection.connect();

                if (connection.getResponseCode() == 200) {
                    log.info(links + " - " + connection.getResponseMessage());
                }
                if (connection.getResponseCode() == 404) {
                    log.info(links + " - " + connection.getResponseMessage());
                }
            }
        } catch (TimeoutException exception) {
            log.error("Timeout Exception " + exception);
        }


    }
}
