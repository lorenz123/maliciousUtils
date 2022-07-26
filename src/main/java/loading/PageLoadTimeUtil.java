package loading;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;


/**
 * This utility class will check the load time of the selected page/url
 */
@Slf4j
public class PageLoadTimeUtil {


    public static WebDriver getPageLoadTime(WebDriver driver, String baseURL) throws TimeoutException {
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
        ExceedLoadTimeUtil.exceedExpectedLoadTime(totalTime);
        return driver;
    }

}
