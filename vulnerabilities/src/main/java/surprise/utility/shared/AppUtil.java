package surprise.utility.shared;

import surprise.utility.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

/**
 * This utility class handles the getBy method that is used for selecting elements
 */
@Slf4j
public class AppUtil {
    public static By getBy(String path, ElementType type) {
        switch (type) {
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

