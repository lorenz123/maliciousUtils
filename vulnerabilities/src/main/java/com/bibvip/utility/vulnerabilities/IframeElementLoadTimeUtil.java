package com.bibvip.utility.vulnerabilities;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;

import static com.bibvip.config.DriverConfig.driver;
import static com.bibvip.consts.ElementType.TAG_NAME;
import static com.bibvip.utility.vulnerabilities.AppUtil.getBy;
import static com.bibvip.utility.vulnerabilities.ExceedLoadTimeUtil.exceedExpectedLoadTime;
import static com.bibvip.utility.vulnerabilities.WaitingTimeUtil.getElementWithPolling;

/**
 * This utility class will check the load time of an iFrame WebElement
 * (The time can be edited depending on the requirements)
 * IMPORTANT!! "always switch content to default after using this"
 */

@Slf4j
public class IframeElementLoadTimeUtil {


    public static WebElement getIframeElementLoadTime(WebDriverWait driverWait, String iframePath, String url, ElementType type) throws TimeoutException {
        long start = System.currentTimeMillis();
        WebElement iframe = getElementWithPolling(driverWait, getBy(iframePath, TAG_NAME)); //Solution to my problem <3
        driver.switchTo().frame(iframe);
        WebElement element = getElementWithPolling(driverWait, getBy(url, type));
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        log.info("Total time to finish loading element : " + element.getText() + " = " + totalTime);
        exceedExpectedLoadTime(totalTime);

        return element;
    }

}
