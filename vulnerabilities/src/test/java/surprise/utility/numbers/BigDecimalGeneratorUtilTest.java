package surprise.utility.numbers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class BigDecimalGeneratorUtilTest {

    @Test
    void generatePositiveBigDecimals() {
        BigDecimalGeneratorUtil.generatePositiveBigDecimals();

    }

    @Test
    void generateNegativeBigDecimals() {
        BigDecimalGeneratorUtil.generatePositiveBigDecimals();
    }
}