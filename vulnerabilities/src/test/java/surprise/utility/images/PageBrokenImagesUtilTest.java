package surprise.utility.images;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageBrokenImagesUtilTest {

    @Test
    void checkBrokenImages() throws Exception {
        String checkUrl = "https://www.bibvip.com/en_US/spot/BTC_USDT";
        PageBrokenImagesUtil.checkBrokenImages(checkUrl);

    }
}