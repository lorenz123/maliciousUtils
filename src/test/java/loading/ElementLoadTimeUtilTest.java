package loading;

import loading.ElementLoadTimeUtil;
import org.junit.jupiter.api.Test;
import config.DriverConfig;
import consts.ElementType;

import java.util.concurrent.TimeoutException;

class ElementLoadTimeUtilTest {

    @Test
    void getWebElementLoadTime() throws TimeoutException {
        //Example: BIBVIP LOGO
        String selector = ".logo";
        ElementType type = ElementType.CSS_SELECTOR;

        ElementLoadTimeUtil.getWebElementLoadTime(DriverConfig.getChromeConfig(), selector, type); //This method has the ExceedLoadTimeUtil method too


    }
}