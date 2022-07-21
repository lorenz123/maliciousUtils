package surprise.utility.images;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import surprise.utility.shared.StatusCheckerUtil;

/**
 * This utility class will check the images in a web-page.
 * @params put valid URL here. (Ex. https://www.bibvip.com/en_US)
 */
@Slf4j
public class PageBrokenImagesUtil {

    public static void checkBrokenImages(String checkURL) throws Exception {
        Document doc = Jsoup.connect(checkURL).get();
        Elements media = doc.select("[src]");
        for (Element src : media) {
            String imageSrc = src.attr("abs:src");

            ImageUriCheckerUtil.checkImageWithUriType(imageSrc);

            if (imageSrc.endsWith("png") || imageSrc.endsWith("webp") || imageSrc.endsWith("svg")) {
                log.info("Images that ends with .png/.webp/.svg src: " + imageSrc);
                StatusCheckerUtil.getStatusLinks(imageSrc);

            }

        }

    }

}
