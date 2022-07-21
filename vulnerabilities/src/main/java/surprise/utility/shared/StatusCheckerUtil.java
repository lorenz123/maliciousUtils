package surprise.utility.shared;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This utility classes were used on the PageBrokenImagesUtil and PageLinksErrorUtils
 * Both these classes uses URLs to check the responseCode
 */
@Slf4j
public class StatusCheckerUtil {

    public static void getStatusLinks(String checkURL) throws IOException {
        URL url = new URL(checkURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(2000);
        connection.connect();
        if (connection.getResponseCode() == 200) {
            log.info("This " + url + " - has a response code of " +connection.getResponseCode()+ " and response message " + connection.getResponseMessage());
        } else if (connection.getResponseCode() >= 400) {
            log.error(url + " - " + connection.getResponseMessage());
        }
    }
}
