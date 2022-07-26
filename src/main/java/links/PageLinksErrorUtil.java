package links;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import shared.StatusCheckerUtil;

import java.io.IOException;
import java.net.*;

/**
 * This utility class will get all the links inside a page and check the status code (200 or 404)
 */
@Slf4j
public class PageLinksErrorUtil {

    public static void checkPageLinksForErrors(String checkURL) throws IOException {
        Document doc = Jsoup.connect(checkURL).get();
        Elements links = doc.select("a[href]");

        String completeLink;

        for (Element link : links) {
            completeLink = link.attr("href");
            if(completeLink.startsWith("/")) {
                //append current url
                URL url = new URL(checkURL);
                completeLink = url.getProtocol() + "://" + url.getHost() + completeLink;
//                log.info("This is the current URL: " + url);
                log.info("URL Found: " + completeLink);
            } else {
                log.info("URL Found : " +completeLink);
            }
            StatusCheckerUtil.getStatusLinks(completeLink);
        }

    }




}
