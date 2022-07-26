package links;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class PageLinksErrorUtilTest {

    @Test
    void checkPageLinksForErrors() throws IOException {
        String checkUrl = "https://www.bibvip.com/en_US/spot/BTC_USDT";
        PageLinksErrorUtil.checkPageLinksForErrors(checkUrl);
    }
}