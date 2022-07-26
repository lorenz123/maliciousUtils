package numbers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@Slf4j
class BigDecimalGeneratorUtilTest {

    @Test
    void generatePositiveBigDecimals() {
        BigDecimal a = BigDecimalGeneratorUtil.generatePositiveBigDecimals();
        BigDecimal b = BigDecimalGeneratorUtil.generatePositiveBigDecimals();

        if(a.compareTo(b) < 0){
            log.info("pass");
        } else {
            log.error("error, not returning a bigdecimal");
        }
    }

    @Test
    void generateNegativeBigDecimals() {
        BigDecimal a = BigDecimalGeneratorUtil.generatePositiveBigDecimals();
        BigDecimal b = BigDecimalGeneratorUtil.generatePositiveBigDecimals();
        if(a.compareTo(b) < 0){
            log.info("pass");
        } else {
            log.error("error, not returning a bigdecimal");
        }
    }
}