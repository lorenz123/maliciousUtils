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

    public static void extractJSLogsInfo(WebDriver driver) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry entry : logEntries){
            log.info(new Date(entry.getTimestamp()) + " | " + entry.getLevel() + " | " + entry.getMessage());

            if(entry != null) {
                log.info("Some JavaScript errors are detected!!!");
            } else {
                log.info("Good thing! The page is free from JavaScript errors!");
            }
        }

    }

}
