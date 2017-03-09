package ua.com.juja.week04;

import java.math.BigInteger;

/**
 * Реализовать метод, который преобразует BigInteger в битовую строку (String из '0' и '1')
 * toBitStr(new BigInteger("2")) = "10" toBitStr(new BigInteger("8")) = "1000"
 * toBitStr(new BigInteger("10")) = "1010" toBitStr(new BigInteger("140")) = "10001100"
 */

public class Lab34 {
    public static String toBitStr(BigInteger arg) {
        if (arg.bitLength() == 0){
            return "0";
        }

        String result = "";

        int [] array = new int [arg.bitLength()];
        BigInteger value = arg;

        int mask = 1;

        for (int i = 0; i < arg.bitLength(); i++){
            if((value.intValue() & mask) == 1){
                array[(arg.bitLength() - 1) - i] = 1;
            } else {
                array[(arg.bitLength() - 1) - i] = 0;
            }
            value =  value.shiftRight(1);
        }

        for (int i = 0; i < array.length; i++){
            result += array[i];
        }
        return result;
    }
}
