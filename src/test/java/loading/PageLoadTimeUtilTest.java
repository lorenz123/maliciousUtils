package loading;

import loading.PageLoadTimeUtil;
import org.junit.jupiter.api.Test;
import config.DriverConfig;

import java.util.concurrent.TimeoutException;

class PageLoadTimeUtilTest {

    @Test
    void getPageLoadTime() throws TimeoutException {
        String testURL = "http://chainupweb.bibtest.com/en_US";
        PageLoadTimeUtil.getPageLoadTime(DriverConfig.getChromeConfig(), testURL);
    }
}