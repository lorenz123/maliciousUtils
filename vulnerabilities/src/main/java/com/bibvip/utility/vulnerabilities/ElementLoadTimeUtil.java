package com.bibvip.utility.vulnerabilities;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;

import static com.bibvip.utility.vulnerabilities.AppUtil.getBy;
import static com.bibvip.utility.vulnerabilities.ExceedLoadTimeUtil.exceedExpectedLoadTime;
import static com.bibvip.utility.vulnerabilities.WaitingTimeUtil.getElementWithPolling;

/**
 * This utility class will get the time it takes for a WebElement to be loaded.
 */
@Slf4j
public class ElementLoadTimeUtil {

    public static WebElement getElementLoadTime(WebDriverWait driverWait, String url, ElementType type) throws TimeoutException {
        long start = System.currentTimeMillis();
        WebElement element = getElementWithPolling(driverWait, getBy(url, type));
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        log.info("Total time to finish loading element : " + element.getText() + " = " + totalTime);
        exceedExpectedLoadTime(totalTime);

        return element;
    }
}
