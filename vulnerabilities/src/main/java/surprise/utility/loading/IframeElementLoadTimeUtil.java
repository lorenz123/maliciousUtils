package surprise.utility.loading;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import surprise.utility.consts.ElementType;
import surprise.utility.shared.AppUtil;

import java.util.concurrent.TimeoutException;

import static surprise.utility.loading.ExceedLoadTimeUtil.exceedExpectedLoadTime;
import static surprise.utility.shared.AppUtil.getBy;

/**
 * This utility class will check the load time of an iFrame WebElement
 * (The time can be edited depending on the requirements)
 * IMPORTANT!! "always switch content to default after using this"
 */

@Slf4j
public class IframeElementLoadTimeUtil {

    public static WebElement getIframeElementLoadTime(WebDriver driver, String iframePath, String selector, ElementType type) throws TimeoutException {

        long start = System.currentTimeMillis();
        WebElement iframe = driver.findElement(AppUtil.getBy("iframe", ElementType.TAG_NAME));
        driver.switchTo().frame(iframe);
        WebElement element = driver.findElement(getBy(selector, type));
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        log.info("Total time to finish loading WebElement with Iframe On: " + element.getText() + " = " + totalTime);
        exceedExpectedLoadTime(totalTime);
        return element;
    }

}
