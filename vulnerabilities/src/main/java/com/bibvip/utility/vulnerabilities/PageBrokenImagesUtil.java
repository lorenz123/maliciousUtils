package com.bibvip.utility.vulnerabilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Slf4j
public class PageBrokenImagesUtil {

    public static void checkBrokenImages(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("img"));
        log.info("Total Images are :" + links.size());

        String currentTime = String.valueOf(System.currentTimeMillis());

        for (int i = 0; i < links.size(); i++) {
            try {
                String data = links.get(i).getAttribute("src");

                String partSeparator = ",";
                URL url = null;
                if (data.contains(partSeparator)) {
                    String encodedImg = data.split(partSeparator)[1];
                    String removeSpacesEncodedImg = encodedImg.replace("%0A", ""); //%0A = \n (line break)

                    byte[] imageData =  Base64.getDecoder().decode((removeSpacesEncodedImg.getBytes(StandardCharsets.UTF_8)));
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                    BufferedImage image = ImageIO.read(bis);

                    bis.close();
                    String extension = "png";
                    String fullPath = System.getProperty("user.home") + File.separator + "Desktop/" + currentTime;

                    File newFolder = new File(fullPath);
                    if(!newFolder.exists()){
                        newFolder.mkdir();
                        log.info("new folder created");
                    }

                    String newFilecurrentTime = String.valueOf(System.currentTimeMillis());
                    String newFullPath = fullPath + "/" + newFilecurrentTime;

                    File outputFile = new File(newFullPath + "." + extension);

                    if(ImageIO.write(image, extension, outputFile)){
                        String path = outputFile.getAbsolutePath();
                        log.info("Valid Image: " + path);
                        data = "https://www.bibvip.com/_nuxt/img/notice.b629813.png"; //valid image to make URL valid, as path is not a real URL, just local filePath6
                    } else {
                        log.error("This image is not valid");
                    }
                }

                url = new URL(data);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(2000);
                connection.connect();
                int code = connection.getResponseCode();

                if (code == 200) {
                    log.info("Valid Image: " + data);
                } else {
                    log.info("Invalid Image detected! " + data);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
