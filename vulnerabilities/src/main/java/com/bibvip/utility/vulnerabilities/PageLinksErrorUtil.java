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

    public static void checkPageLinksForErrors(WebDriver driver) throws IOException {

        List<WebElement> elementList = driver.findElements(By.tagName("a"));

        for (int j = 0; j <= elementList.size(); j++) {

            WebElement element = elementList.get(j);
            String links = element.getAttribute("href");
            URL link = new URL(links);

            HttpURLConnection connection = (HttpURLConnection) link.openConnection();

            connection.setConnectTimeout(2000);

            //TODO SocketException: Software caused connection abort: recv failed
            connection.connect();

            if (connection.getResponseCode() == 200) {
                log.info(links + " - " + connection.getResponseMessage());
            }
            if (connection.getResponseCode() == 404) {
                log.info(links + " - " + connection.getResponseMessage());
            }
        }


    }
}
