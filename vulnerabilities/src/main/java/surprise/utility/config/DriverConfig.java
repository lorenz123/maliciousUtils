package surprise.utility.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

/**
 * This class has the driver configs.
 * a getPageLoadTime() method was also included to get the time it takes for the browser to be in ready state.
 * a extractJSLogsInfo() method was also included to get any javascript errors when the browser was launched.
 */
@Slf4j
public class DriverConfig {
    public static WebDriver driver = null;
    public static WebDriverWait driverWait = null;

    public static WebDriver getChromeConfig() throws TimeoutException {
        String environmentToTest = "https://www.bibvip.com/en_US";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(environmentToTest);
        driver.manage().window().maximize();
//        PageLoadTimeUtil.getPageLoadTime(BaseURL.PROD_BASE_URL);
        log.info("Connection Established!");
        return driver;
    }
}