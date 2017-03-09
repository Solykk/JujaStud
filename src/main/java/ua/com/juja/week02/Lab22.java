package ua.com.juja.week02;

/**
 * Реализуйте метод rotateClockwise(int[][]) класса ArrayUtils, который
 * 1) проверяет, что метод получил "квадратную" матрицу (допустимые размеры 1x1, 2x2, 3x3, ...) иначе возвращать null;
 * (возможные ошибки: null вместо массива, одна из размерностей = 0, длина не равна ширине, есть строки разной длины,
 * есть строки с null вместо одномерных массивов)
 * 2) "проворачивает" массив по часовой стрелке на 90 градусов, т.е [1] -> [1] [[1, 2], [3, 4]] -> [[3, 1], [4, 2]]
 * [[1, 2, 3], [4, 5, 6], [7, 8, 9]] -> [[7, 4, 1], [8, 5, 2], [9, 6, 3]] ...
 */

public class Lab22 {
    public static int[][] rotateClockwise(int[][] arg) {

        if (arg == null) {return null;}
        else if (arg.length == 0 ) {return null;}

        for (int index = 0; index < arg.length; index++){
            if ( arg[index] == null){
                return null;
            }
            else if(arg.length != arg[index].length){
                return null;
            }
        }

        int[][] argCopy = new int[arg.length][arg.length];
        for (int in = 0; in < arg.length; in++) {
            for (int jin = 0; jin < arg.length; jin++) {
                argCopy[in][jin] = arg[in][jin];
            }
        }


        for(int tt = 0; tt < arg.length / 2; tt++) {
            for (int i = tt; i < arg.length - tt; i++) {
                argCopy[i][(arg.length - 1) - tt] = arg[tt][i];

            }
        }
        for(int rr = 0; rr < arg.length / 2; rr++) {
            for (int f = rr; f < arg.length - rr; f++) {
                argCopy[(arg.length - 1) - rr][(arg.length - 1) - f] = arg[f][(arg.length - 1) - rr];

            }
        }
        for (int ee = 0; ee < arg.length / 2; ee++) {
            for (int j = ee; j < arg.length - ee; j++) {
                argCopy[j][ee] = arg[(arg.length - 1) - ee][j];

            }
        }
        for (int ww = 0; ww < arg.length / 2; ww++) {
            for (int h = ww; h < arg.length - ww; h++) {
                argCopy[ww][(arg.length - 1) - h] = arg[h][ww];

            }
        }
        return argCopy;
    }
}
