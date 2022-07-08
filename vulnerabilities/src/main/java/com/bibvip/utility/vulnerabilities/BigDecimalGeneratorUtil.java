package com.bibvip.utility.vulnerabilities;

import java.math.BigDecimal;

/**
 * This utility classes generate a BigDecimal values of positive or negative.
 */
public class BigDecimalGeneratorUtil {

    public static BigDecimal generatePositiveDecimals(){ return BigDecimal.valueOf(Math.random() * (Math.random() * 99.99)); }

    public static BigDecimal generateNegativeDecimals(){
        return BigDecimal.valueOf(Math.random()*-99.99);
    }

}
