package errors;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static config.DriverConfig.getChromeConfig;

class JavascriptErrorsUtilTest {

    @Test
    void extractJSLogsInfo() throws TimeoutException {
        JavascriptErrorsUtil.extractJSLogsInfo(getChromeConfig());

    }
}