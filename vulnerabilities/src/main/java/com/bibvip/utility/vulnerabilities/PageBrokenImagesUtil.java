package com.bibvip.utility.vulnerabilities;

import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.uri.Uri;
import org.bouncycastle.util.encoders.UrlBase64Encoder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.*;
import java.util.List;

@Slf4j
public class PageBrokenImagesUtil {

    public static void checkBrokenImages(WebDriver driver) {
       List<WebElement> links = driver.findElements(By.tagName("img"));

       log.info("Total Images are :" +links.size());

       //TODO: IndexOutOfBoundsException when index and size has the same value.
       for (int i = 0; i < links.size(); i++){
           try {
               String nextHref = links.get(i).getAttribute("src");

               //TODO : research how to fetch image data with URI type that will not cause unknown protocol:data on URL method
                URL url = new URL(nextHref);

               //make this url will be compared to a URL with URI data
               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               connection.setRequestMethod("GET");
               connection.setConnectTimeout(2000);
               connection.connect();
               int code = connection.getResponseCode();

               if(code == 200) {
                   log.info("Valid Image: " + nextHref);
               } else {
                   log.info("Invalid Image detected! " +nextHref);
               }


           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

}
