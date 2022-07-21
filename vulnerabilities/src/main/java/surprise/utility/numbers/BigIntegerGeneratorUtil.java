package surprise.utility.numbers;

import java.math.BigInteger;
/**
 * This utility classes generate a BigInteger values of positive or negative.
 */
public class BigIntegerGeneratorUtil {

    public static BigInteger generatePositiveIntegers(){ return BigInteger.valueOf((long) (Math.random() * (Math.random() * 999999999))); }

    public static BigInteger generateNegativeIntegers(){ return BigInteger.valueOf((long) (Math.random() * (Math.random() * 999999999))).negate(); }
}
