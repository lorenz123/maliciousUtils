package surprise.utility.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigIntegerGeneratorUtilTest {

    @Test
    void generatePositiveIntegers() {
        BigIntegerGeneratorUtil.generatePositiveIntegers();
    }

    @Test
    void generateNegativeIntegers() {
        BigIntegerGeneratorUtil.generateNegativeIntegers();
    }
}