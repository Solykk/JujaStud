package ua.com.juja.week01;

/**
 * Реализуйте метод swapBits(b, i, j),
 * который производит "рокировку" битов с номерами i и j,
 * то есть swapBits(0b1111_0000, 0, 6) = 0b1011_0001 swapBits(0b0000_1000, 3, 1) = 0b0000_0010
 */

public class Lab07 {
    public static byte swapBits(byte b, int i, int j) {
        byte maskI = (byte) (((1 << i) & b) >> i);
        byte maskJ = (byte) (((1 << j) & b) >> j);

        if (maskI == maskJ) {
            return b;
        } else {
            if (maskI == 1) {
                b = (byte)(b ^ (1 << i));
                b = (byte)(b | (1 << j));
                return b;
            } else {
                b = (byte)(b ^ (1 << j));
                b = (byte)(b | (1 << i));
                return b;
            }
        }
    }
}
