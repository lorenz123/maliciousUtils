package com.bibvip.utility.vulnerabilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPInputStream;

import static com.bibvip.utility.vulnerabilities.AppUtil.sizeOfURIImage;

@Slf4j
public class PageBrokenImagesUtil {

    public static void checkBrokenImages(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("img"));

        log.info("Total Images are :" + links.size());

        //TODO: IndexOutOfBoundsException when index and size has the same value.
        for (int i = 0; i < links.size(); i++) {
            try {
                String data = links.get(i).getAttribute("src");

                //TODO : research how to fetch image data with URI type that will not cause unknown protocol:data on URL method
                String partSeparator = ",";
                URL url = null;
                if (data.contains(partSeparator)) {
                    //convert the URI to a URL... how?????
                    String encodedImg = data.split(partSeparator)[1];

                    int imageSize = encodedImg.length();
                    log.info("Image size is " + imageSize);
                    if (imageSize <= 0) {
                        log.info("Image with Data URI type is 0!" + data);
                    } else {
                        log.info("Image with Data URI type is valid!!! - " + data);
                    }
                    //TODO make data, not return null but not return the URI data type also, because it produces unknown protocol error
                    data = "https://www.bibvip.com/_nuxt/img/merit_04@3x.60f9d5a.png";
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

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            //BASE64Decoder decoder = new BASE64Decoder();
            imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }


    public static void convertImageToFile(BufferedImage bi, String extension, String fullPath) throws IOException {
        File outputfile = new File(fullPath + "." + extension);
        ImageIO.write(bi, extension, outputfile);
    }


    public static void main(String[] args) throws IOException {
        String data2 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAIAAAAiOjnJAAADUElEQVR42u3bwXHjQAxFQeaftJ2Bq1zEB8CZfletZZHTe4BBPT9SoMctEFgCS2BJYAksgSWBJbAElgSWwBJYElgCS2BJYAksgSWBJbAElgSWwBJYEli6ANbT1d+/91+v5q7oi3cSLLDAAgsssMACC6xbYU2985t//OYYcm/1iTMCCyywwAILLLDAAusgWG1zX27eLPzMO+8kWGCBBRZYYIEFFlhgbTqktukst4YCCyywwAILLLDAAgusU2B94szAAgsssMACCyywwAJrMaw2srkhse3yPY8FFlhggQUWWGCBBVYvrFy5CWvnq213EiywwAILLLDAAgusa2AtqfDO5vQ3HPDY/QcLLLDAAgsssMAC6/MrnakvROTGsbZLaHvSCyywwAILLLDAAgusW2G1PeSfG9baPtXy70eABRZYYIEFFlhggXX3X95zq5WpDc/U3qnwjMACCyywwAILLLDAugZW7hgKf1HuOw65tczUZwYLLLDAAgsssMAC61xYub1E21u1vXPhAW/b/4AFFlhggQUWWGCBdfpKp21oyu1hCo/Q81hggQUWWGCBBRZYYI1OhVMrjpzCtpVO7n87WGCBBRZYYIEFFlhgVW9L3oyfOdBLfG9zBhZYYIEFFlhggQXWF2DlFLadytNV22cGCyywwAILLLDAAgusalhvXs1NlFOHtGSzBBZYYIEFFlhggQXWubDaFiBLVhy5n81dIFhggQUWWGCBBRZYYIWP4RP6p37RtlMACyywwAILLLDAAuv0qbDwCHPz5rMyf24ACyywwAILLLDAAus7tT2QVHhIUz/bcRxggQUWWGCBBRZYYJ02FeaGtdweptBZ4RVZ6YAFFlhggQUWWGCBFZ7Opmaown3I1GplCiVYYIEFFlhggQUWWNfAys19U4Nt7vLbRmawwAILLLDAAgsssMDaBCs3UbZ9PSS3OwILLLDAAgsssMACC6xeWG10Cg+p8IpyD42BBRZYYIEFFlhggXUrrLZ3zt3oJY9n5fY/YIEFFlhggQUWWGDdCmvJI0e5x6TatkO5jwEWWGCBBRZYYIEF1q2wJLAElsCSwBJYAktgSWAJLIElgSWwBJYElsASWBJYAktgSWAJLIElgSWwBJYElsDSPf0CDnrC2gxxIJ0AAAAASUVORK5CYII=";

        String encodingPrefix = "base64,";
        int contentStartIndex = data2.indexOf(encodingPrefix) + encodingPrefix.length();
        byte[] imageData =  Base64.getDecoder().decode((data2.substring(contentStartIndex)));
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        BufferedImage image = ImageIO.read(bis);
        int height = image.getHeight();
        int width = image.getWidth();

        log.info("height of this image" + height);
        log.info("width of this image" + width);

        bis.close();
        convertImageToFile(image, "png", System.getProperty("user.home") + File.separator+ "Desktop/myfile2");
    }

    private static byte[] cleaner(String data) {
        String partSeparator = ",";
        if (data.contains(partSeparator)) {
            String encodedImg = data.split(partSeparator)[1];
            byte[] decodedImg = Base64.getDecoder().decode(encodedImg.getBytes(StandardCharsets.UTF_8));
            return decodedImg;
        }
        return null;
    }


}
