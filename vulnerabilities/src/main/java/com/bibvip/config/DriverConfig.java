package com.bibvip.config;

import com.bibvip.consts.ElementType;
import com.bibvip.utility.vulnerabilities.LoadTimeUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeoutException;

import static com.bibvip.consts.BaseURL.PROD_BASE_URL;
import static com.bibvip.consts.ElementType.*;
import static com.bibvip.utility.vulnerabilities.LoadTimeUtil.*;
import static com.bibvip.utility.vulnerabilities.ThinkingTimeUtil.*;

@Slf4j
public class DriverConfig {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public static WebDriver getChromeConfig() throws MalformedURLException, TimeoutException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = getWebDriverWait(driver);

        //get loadtime of browser load
        getLoadTime(PROD_BASE_URL);
        log.info("Connection Established!");

        return driver;
    }
}