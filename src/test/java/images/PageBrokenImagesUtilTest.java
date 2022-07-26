package images;

import org.junit.jupiter.api.Test;

class PageBrokenImagesUtilTest {

    @Test
    void checkBrokenImages() throws Exception {
        String checkUrl = "https://www.bibvip.com/en_US/spot/BTC_USDT";
        PageBrokenImagesUtil.checkBrokenImages(checkUrl);

    }
}