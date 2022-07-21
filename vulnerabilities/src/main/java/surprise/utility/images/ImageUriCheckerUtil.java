package surprise.utility.images;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * This utility class will extract the JavaScript Errors of the current page.
 */
@Slf4j
public class ImageUriCheckerUtil {

    public static void checkImageWithUriType(String imageSrc) throws IOException {
        String partSeparator = ",";
        if (imageSrc.contains(partSeparator)) {
            String dataUriImg = imageSrc.split(partSeparator)[1];
            String dataUriImgRemoveSpaces = dataUriImg.replace("\n", "");
             dataUriImgRemoveSpaces = dataUriImg.replace("%0A", "");
            byte[] imageData =  Base64.getDecoder().decode((dataUriImgRemoveSpaces.getBytes(StandardCharsets.UTF_8)));
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage image = ImageIO.read(bis);

            if(image == null){
                log.error("This image with data type URI is a null");
            } else {
                log.info("Valid Images with Data URI type src: " + imageSrc);
            }

        }

    }

}
