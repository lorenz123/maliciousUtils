package com.bibvip.utility.vulnerabilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Date;

/**
 * This utility class will extract the JavaScript Errors of the current page.
 */
@Slf4j
public class JavascriptErrorsUtil {

    public static String extractJSLogsInfo(WebDriver driver) {

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        String result = null;
        for(LogEntry entry : logEntries){
            result = new Date(entry.getTimestamp()) + " | " + entry.getLevel() + " | " + entry.getMessage();
            log.info("Some JavaScript errors are detected!!! {}", result);
        }
        if(result == null){
            log.info("Good thing! The page is free from JavaScript errors!");
        }
        return result;

    }

}
