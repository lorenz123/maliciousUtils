package loading;

import consts.ElementType;
import org.openqa.selenium.WebDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeoutException;

import static shared.AppUtil.getBy;

/**
 * This utility class will get the time it takes for a WebElement to be loaded.
 */
@Slf4j
public class ElementLoadTimeUtil {

    public static WebElement getWebElementLoadTime(WebDriver driver, String selector, ElementType type) throws TimeoutException {

        long start = System.currentTimeMillis();
        WebElement element = driver.findElement(getBy(selector, type));
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        log.info("Total time to finish loading WebElement ("+selector+") : " + element.getText() + " = " + totalTime + "ms");
        
        ExceedLoadTimeUtil.exceedExpectedLoadTime(totalTime);
        return element;
    }
}
