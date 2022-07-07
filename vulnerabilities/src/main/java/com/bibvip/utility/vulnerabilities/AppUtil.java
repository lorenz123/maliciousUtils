package com.bibvip.utility.vulnerabilities;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
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

    public static byte[] sizeOfURIImage(String base64) throws UnsupportedEncodingException {
        return Base64.getDecoder().decode(base64.split("\\.")[0].
                replace('-', '+').replace('_', '/'));
//        String imageDecode = URLDecoder.decode(base64, "UTF-8");
//        log.info("imageDecode = " + imageDecode);
/*
        byte[] decodeImageToURL = Base64.getDecoder().decode(base64.replaceAll("-", "+").replaceAll("_", "/"));
        log.info("decodeImageToURL = " + decodeImageToURL);
        return decodeImageToURL;*/
    }
}

