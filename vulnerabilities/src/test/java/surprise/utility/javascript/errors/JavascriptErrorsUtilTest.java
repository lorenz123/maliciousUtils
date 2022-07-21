package surprise.utility.javascript.errors;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static surprise.utility.config.DriverConfig.getChromeConfig;

class JavascriptErrorsUtilTest {

    @Test
    void extractJSLogsInfo() throws TimeoutException {
        JavascriptErrorsUtil.extractJSLogsInfo(getChromeConfig());

    }
}