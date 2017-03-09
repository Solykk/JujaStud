package ua.com.juja.week01;

import java.util.ArrayList;

/**
 * На вход подается одномерный массив. Необходимо, найти диапазон максимальной ширины,
 * элементы которого положительные (больше 0)
 * В качестве ответа должен быть массив из 2х элементов, где
 * - элемент №0 - индекс элемента левой границы отрезка
 * - элемент №1 - индекс элемента правой границы отрезка
 * Если таких отрезков несколько - вернуть самый левый. Если в массиве отсутствует такой отрезок
 * (все числа отрицательны) - вернуть пустой массив.
 * Например
 * lookFor([1, 1, 1]) = [0, 2]
 * lookFor([0, 1, 1]) = [1, 2]
 * lookFor([1, 1, 0]) = [0, 1]
 * lookFor([0, -100, 1, 1, 0, -1]) = [2, 3]
 * lookFor([1, 1, 0, 1, 1]) = [0, 1] // возвращаем левый
 * lookFor([0, -1, 0, -1]) = [] // отсутствуют положительные числа
 */

public class Lab12 {
    public static int[] lookFor(int[] array) {
        int counterMax = 0;
        int indexFrom = 0;
        int i;
        int [] result = new int [2];

        ArrayList<int []> many = new ArrayList<>();

        if(array.length == 1){
            if(array[0] > 0){
                return new int[]{0,0};
            } else {
                return new int[0];
            }
        }
        for(i = 0; i < array.length; i++){

            if(array[i] > 0 && counterMax == 0){
                counterMax++;
                indexFrom = i;

            } else if(array[i] <= 0  && counterMax > 0){
                result[0] = indexFrom;
                result[1] = i - 1;

                if(many.isEmpty()) {
                    many.add(new int[]{result[0], result[1], counterMax});

                } else {

                    if(counterMax == many.get(many.size() - 1)[2]){
                        many.add(new int[]{result[0], result[1], counterMax});

                    } else if(counterMax > many.get(many.size() - 1)[2]){
                        many.clear();
                        many.add(new int[]{result[0], result[1], counterMax});

                    } else {
                        break;
                    }
                }

                counterMax = 0;

            } else if(array[i] > 0 && counterMax > 0 && i != array.length - 1){
                counterMax++;
                result[1] = i;

            } else if(array[i] <= 0 && counterMax == 0 && i == array.length - 1){
                many.add(new int[0]);
                counterMax = 0;

            } else if(array[i] > 0 && counterMax > 0 && i == array.length - 1){
                counterMax++;
                result[1] = i;
                many.add(new int[]{indexFrom, result[1], counterMax});
                counterMax = 0;

            }
        }

        if(many.get(0).length == 0){
            return new int[0];

        } else {
            result[0] = many.get(0)[0];
            result[1] = many.get(0)[1];
            return result;
        }
    }
}
