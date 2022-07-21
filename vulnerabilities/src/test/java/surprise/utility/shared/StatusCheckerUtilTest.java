package surprise.utility.shared;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class StatusCheckerUtilTest {

    @Test
    void getStatusLinks() throws IOException {
        String checkUrl = "https://www.bibvip.com/en_US/spot/BTC_USDT";
        StatusCheckerUtil.getStatusLinks(checkUrl);
    }
}