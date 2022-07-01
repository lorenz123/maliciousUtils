package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

@Slf4j
public class DriverConfig {

    public static WebDriver getChromeConfig() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("https://www.bibvip.com/en_US/futures");
        driverChrome.manage().window().maximize();
        log.info("Windows OS Detected - Connection Established!");
        return driverChrome;

    }
}