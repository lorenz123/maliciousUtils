package surprise.utility.numbers;

import java.math.BigDecimal;

public class BigDecimalGeneratorUtil {

    public static BigDecimal generatePositiveBigDecimals(){ return BigDecimal.valueOf(Math.random() * (Math.random() * 99.99)); }

    public static BigDecimal generateNegativeBigDecimals(){  return BigDecimal.valueOf(Math.random() * (Math.random() * 99.99)).negate(); }
}
