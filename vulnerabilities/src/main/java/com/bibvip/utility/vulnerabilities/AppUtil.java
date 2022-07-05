package com.bibvip.utility.vulnerabilities;

import com.bibvip.consts.ElementType;
import org.openqa.selenium.By;

public class AppUtil {
    public static By getBy(String path, ElementType type) {
        switch (type){
            case ID:
                return By.id(path);
            case NAME:
                return By.name(path);
            case X_PATH:
                return By.xpath(path);
            case TAG_NAME:
                return By.tagName(path);
            case CSS_SELECTOR:
                return By.cssSelector(path);
            default:
                throw new IllegalArgumentException();
        }
    }
}
