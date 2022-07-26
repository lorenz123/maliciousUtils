package loading;

import org.junit.jupiter.api.Test;
import config.DriverConfig;
import consts.ElementType;

import java.util.concurrent.TimeoutException;

class IframeElementLoadTimeUtilTest {

    @Test
    void getIframeElementLoadTime() throws TimeoutException {
        //Example: BIBVIP LOGO
        String selector = "header-toolbar-chart-styles";
        ElementType type = ElementType.ID;
        IframeElementLoadTimeUtil.getIframeElementLoadTime(DriverConfig.getChromeConfig(), selector, type);
    }
}