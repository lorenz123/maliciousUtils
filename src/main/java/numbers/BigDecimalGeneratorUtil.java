package numbers;

import java.math.BigDecimal;
/**
 * This utility classes generate a BigDecimal values of positive or negative.
 */
public class BigDecimalGeneratorUtil {

    public static BigDecimal generatePositiveBigDecimals(){ return BigDecimal.valueOf(Math.random() * (Math.random() * 99.99)); }

    public static BigDecimal generateNegativeBigDecimals(){  return BigDecimal.valueOf(Math.random() * (Math.random() * 99.99)).negate(); }
}
