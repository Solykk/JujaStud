package ua.com.juja.week02;

/**
 * Это пример небольшого и ограниченного по функциональности рекурсивного парсера арифметических выражений.
 * Он умеет:
 * 1) встретив скобки с двух сторон – свести задачу к анализу содержимого скобок (пример:”(1+1)” -> “1+1″,
 * пример “(1+(2/3))” -> “1+(2/3)”);
 * 2) встретив число-знак-XXX – свести задачу к анализу XXX (пример:”1*(10-3)” -> “(10-3)”,
 * пример “3+(2/(9+1))” -> “(2/(9+1)”);
 *
 * Задание: переписать его, что бы он ВМЕСТО пункта 2 дела пункт 2′
 * 2′) встретив XXX-знак-число – сведил задачу к анализу XXX. (пример:”(10-3)*1″ -> “(10-3)”,
 * пример “(2/(9+1))+3″ -> “(2/(9+1)”);
 * Предупреждение #1: это не полноценный парсер арифметических выражений, есть множество корректных выражений
 * на которых он “падает” или вычисляет некорректно (“(1+1)+(1+1)”, “-1″, …).
 * Предупреждение #2: в условиях лабораторной ожидается, что старые выражения вида число-знак-XXX больше на разбираются.
 */

public class Lab18 {

    public static int eval(String expr) {
        return eval(expr, expr.length() - 1, 0);
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == ')') {
            return eval(expr, from - 1, to + 1);
        } else {
            int pos = from;

            while (pos > to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos--;
                } else {
                    int rightOperand = Integer.valueOf(expr.substring(pos + 1, from+1));
                    char operation = expr.charAt(pos);
                    int leftOperand = eval(expr, pos - 1, to);

                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(to, from + 1));
        }
    }
}
