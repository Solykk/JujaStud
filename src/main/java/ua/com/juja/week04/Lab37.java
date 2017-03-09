package ua.com.juja.week04;

/**
 * Реализовать функцию, которая делает циклический сдвиг букв вправо, то есть rightShift("ABCDE", 1) =
 * "EABCD" rightShift("ABCDE", 2) = "DEABC" rightShift("ABCDE", 3) = "CDEAB" rightShift("ABCDE", 4) =
 * "BCDEA" Допустимо сдвигать на расстояние больше длины строки rightShift("ABCDE", 5) = "ABCDE" rightShift("ABCDE", 6)
 * = "EABCD" rightShift("ABCDE", 7) = "DEABC" Допустимо сдвигать на отрицательное расстояние (выходит сдвиг влево)
 * rightShift("ABCDE", -1) = "BCDEA" rightShift("ABCDE", -2) = "CDEAB" rightShift("ABCDE", -7) = "CDEAB".
 * Сдвиг на расстояние 0 и сдвиги строк длиной 0 и 1 символ - разрешены.
 */

public class Lab37 {
    public static String rightShift(String arg, int delta) {
        int tmpDelta = delta;
        if((delta > arg.length() || delta < arg.length()) && arg.length() != 0){
            tmpDelta = delta - (delta/arg.length() * arg.length());
        }
        char [] array = arg.toCharArray();
        char [] result  = new char[array.length];

        for(int  i = 0; i < array.length; i++){
            int tmp = tmpDelta + i;
            if(tmp >= array.length){
                result[tmp - array.length] = array[i];
            } else if(tmp < 0){
                result[array.length + tmp] = array[i];
            } else {
                result[tmp] = array[i];
            }
        }
        return new String(result);
    }
}