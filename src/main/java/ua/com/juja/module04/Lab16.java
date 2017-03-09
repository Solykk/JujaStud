package ua.com.juja.module04;

import java.util.Arrays;

/**
 * Такая версия алгоритм сортировки вставками
 *
 * реализована не оптимально, так как внутренний цикл while
 * - ищет позицию для вставки, перебирая последовательно элементы, при этом он
 * - поэлементно "смещает" массив.
 *
 * В целях оптимизации перепишите алгоритм:
 * 1. Ищите позицию для вставки элемента бинарным поиском (Arrays.binarySearch(...)).
 * 2. Найдя позицию - смещайте всю часть массива за один вызов (System.arraycopy(...)).
 * В моих экспериментах эти две оптимизации ускорили сортировку в 2.2-2.6 раза. Скорость сортировки измерял данным кодом
 */

public class Lab16 {
    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int index = Arrays.binarySearch(arr, 0, k, newElement);
            if (index < 0) {
                index = -(index) - 1;
            }
            System.arraycopy(arr, index, arr, index + 1, k - index);
            arr[index] = newElement;
        }
    }
}
