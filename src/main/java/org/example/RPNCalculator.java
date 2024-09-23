package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Сергеев Даниил
 * Калькулятор вычисления польской нотации
 */
public class RPNCalculator {

    /**
     * Стэк для вычислений
     */
    public static Stack<Integer> stack = new Stack<>();

    /**
     * Главная функция программы
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в обратной польской нотации (например: '3 4 +'):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double result = evaluateRPN(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    /**
     * Вычисления польской нотации
     * @param expression - строка для вычисления
     * @return - результат польской нотации
     * @throws IllegalArgumentException - выбрасывание исключения в том случае если в строке не равна 3 элементам
     * @throws NumberFormatException - выбрасывание исключения в том случае если в строке не целочисленная запись
     */

    public static double evaluateRPN(String expression) throws Exception {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            switch (token) {
                case "+":
                    plusOperation();
                    break;
                case "-":
                    minusOperation();
                    break;
                case "*":
                    multiplicationOperation();
                    break;
                case "/":
                    divisionOperation();
                    break;
                default:
                    try {
                        stack.push(Integer.parseInt(token));
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Неверный символ: " + token);
                    }
            }
        }
        return stack.pop();
    }

    /**
     * Вычисления операции сложения
     */
    public static void plusOperation(){
        stack.push(stack.pop() + stack.pop());
    }

    /**
     * Вычисления операции вычитания
     */
    public static void minusOperation(){
        stack.push(stack.pop() - stack.pop());
    }

    /**
     * Вычисления операции деления
     */
    public static void divisionOperation(){
        stack.push(stack.pop() / stack.pop());
    }

    /**
     * Вычисления операции умножения
     */
    public static void multiplicationOperation(){
        stack.push(stack.pop() * stack.pop());
    }
}
