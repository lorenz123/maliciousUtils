package com.bibvip.config;

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

import static com.bibvip.consts.BaseURL.PROD_BASE_URL;
import static com.bibvip.utility.vulnerabilities.BigDecimalGeneratorUtil.generateNegativeDecimals;
import static com.bibvip.utility.vulnerabilities.BigDecimalGeneratorUtil.generatePositiveDecimals;
import static com.bibvip.utility.vulnerabilities.BigIntegerGeneratorUtil.generateNegativeIntegers;
import static com.bibvip.utility.vulnerabilities.BigIntegerGeneratorUtil.generatePositiveIntegers;
import static com.bibvip.utility.vulnerabilities.JavascriptErrorsUtil.extractJSLogsInfo;
import static com.bibvip.utility.vulnerabilities.PageLoadTimeUtil.getPageLoadTime;
import static com.bibvip.utility.vulnerabilities.WaitingTimeUtil.getWebDriverWait;
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

        DesiredCapabilities capabilities = new DesiredCapabilities();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driverWait = getWebDriverWait(driver);

        getPageLoadTime(PROD_BASE_URL);
        log.info("Connection Established!");
        extractJSLogsInfo(driver);

        log.info("Random Positive Doubles : " + generatePositiveDecimals());
        log.info("Random Negative Doubles : " + generateNegativeDecimals());
        log.info("Random Positive Integers : " + generatePositiveIntegers());
        log.info("Random Positive Integers : " + generateNegativeIntegers());
        return driver;
    }
}