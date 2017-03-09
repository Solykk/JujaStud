package ua.com.juja.week01;

/**
 * Реализовать функцию, которая по целочисленому аргументу c возвращает количество целочисленных решений неравенства
 * a*a + b*b <= c a > 0 b > 0
 * Например
 * lookFor(14) == 8
 * поскольку для решения подходят следующие пары значений
 * (a=1,b=1), (a=1,b=2), (a=1,b=3), (a=2,b=1), (a=2,b=2), (a=2,b=3), (a=3,b=1), (a=3,b=2)
 */

public class Lab11 {
    public static int lookFor(int max) {
        int a = 1;
        int b = 1;
        int counter = 0;
        int exit = 1;
        while(exit != 5 ){
            int var = a*a + b*b;
            if(var <= max){
                counter++;
                b++;
                exit = 1;
            } else {
                exit += 2;
                a++;
                b = 1;
            }
        }
        return counter;
    }
}
