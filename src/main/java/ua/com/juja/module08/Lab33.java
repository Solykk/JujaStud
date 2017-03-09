package ua.com.juja.module08;

import java.math.BigInteger;

/**
 * Предположим, что мы работаем с дробями, представляя их как пару BigInteger-ов. 2/3 будем представлять
 * как BigInteger[] x = {new BigInteger("2"), new BigInteger("3")}; Реализовать метод, который
 * обеспечивает - сложение дробей 1/3 + 1/3 = 2/3 1/2 + 1/3 = 5/6 - итоговая дробь должна быть
 * несократимой 1/2 + 1/2 = 1/1 (а не 2/2) 2/3 - 1/6 = 1/2 (а не 3/6) 1/2 + (-1)/2 = 0/1 (а не 0/2)
 * ---
 * P.S. Возможно, вам потребуется метод BigInteger.gcd().
 */

public class Lab33 {
    public static BigInteger[] sum(BigInteger[] x, BigInteger[] y) {
        if(x == null || y == null){
            return null;
        }

        for (int i = 0; i < 2 ; i++){
            if(x[i] == null || y[i] == null || x[i].intValue() == 0 || y[i].intValue() == 0 ){
                return null;
            }
        }

        BigInteger denominator = x[1].multiply(y[1]);
        BigInteger numerator = x[0].multiply(denominator.divide(x[1])).add(y[0].multiply(denominator.divide(y[1])));

        BigInteger gcd = denominator.gcd(numerator);

        return new BigInteger[]{numerator.divide(gcd), denominator.divide(gcd)};
    }
}
