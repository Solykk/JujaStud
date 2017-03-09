package ua.com.juja.week01;

/**
 * Отфильтровать массив так, чтобы оставить только четные элементы.
 * Для проверки четности можно использовать операцию остаток от деления - %
 * 3 % 2 == 1;
 * 6 % 2 == 0;
 * Исходящий массив для простоты, должен быть того же размера,
 * что и входящий. Например, для {4, 3, 5, 6, 7, 9} -> {4, 6, 0, 0, 0, 0}
 */

public class Lab09 {
    public static int [] filterEven(int [] nums){
        int [] result = new int [nums.length];
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0){
                result[counter] = nums[i];
                counter++;
            }
        }
        return result;
    }
}
