package shared;

import org.junit.jupiter.api.Test;
import shared.StatusCheckerUtil;

import java.io.IOException;

class StatusCheckerUtilTest {

    @Test
    void getStatusLinks() throws IOException {
        String checkUrl = "https://www.bibvip.com/en_US/spot/BTC_USDT";
        StatusCheckerUtil.getStatusLinks(checkUrl);
    }
}