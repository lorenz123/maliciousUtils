package loading;

import config.DriverConfig;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

class PageLoadTimeUtilTest {

    @Test
    void getPageLoadTime() throws TimeoutException {
        String testURL = "http://chainupweb.bibtest.com/en_US";
        PageLoadTimeUtil.getPageLoadTime(DriverConfig.getChromeConfig(), testURL);
    }
}