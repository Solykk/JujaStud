package ua.com.juja.week01;

/**
 * В коде инвертирования массива

 * public class ArrayInverter {
 *      public static void invert(int[] arr) {
 *          for (int k = 0; k < arr.length / 2; k++) {
 *              int tmp = arr[k];
 *              arr[k] = arr[arr.length - k - 1];
 *              arr[arr.length - k - 1] = tmp;
 *          }
 *      }
 * }
 * необходимо переписать цикл с инкремента счетчика
 * от 0 до середины массива на цикл от середины массива
 * до 0 (инкремент (k++) заменить на декремент (k--)).
 */
public class Lab08 {
    public static void invert(int[] arr) {
        for (int k = arr.length / 2; k > 0; k--) {
            int tmp = arr[k - 1];
            arr[k - 1] = arr[arr.length - k];
            arr[arr.length - k] = tmp;
        }
    }
}
