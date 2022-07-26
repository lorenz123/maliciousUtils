package numbers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

@Slf4j
class BigIntegerGeneratorUtilTest {

    @Test
    void generatePositiveIntegers() {
        BigInteger a = BigIntegerGeneratorUtil.generatePositiveIntegers();
        BigInteger b = BigIntegerGeneratorUtil.generatePositiveIntegers();
        if(a.compareTo(b) < 0){
            log.info("pass");
        } else {
            log.error("error, not returning a bigInteger");
        }
    }

    @Test
    void generateNegativeIntegers() {
        BigInteger a = BigIntegerGeneratorUtil.generateNegativeIntegers();
        BigInteger b = BigIntegerGeneratorUtil.generateNegativeIntegers();
        if(a.compareTo(b) < 0){
            log.info("pass");
        } else {
            log.error("error, not returning a bigInteger");
        }
    }
}