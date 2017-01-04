package com.javarush.test.level20.lesson10.bonus01;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Before{
    private static final int CHAR_TO_INT_DELTA = 48;

    private static final int COMPARE_MAX_VALUE = 500_000_000;

    private static final int MILLISECONDS = 1000;

    public static void main(String[] args) {
        long startTime = new Date().getTime();
        int[] numbers = getNumbers(COMPARE_MAX_VALUE);
        long endTime = new Date().getTime();
        System.out.println("Total (sec): " + (endTime - startTime) / MILLISECONDS);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    private static int[] getNumbers(int maxValue) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= maxValue; i++) {
            if (compareWithAlgorithm(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean compareWithAlgorithm(int value) {
        int algorithmResult = 0;
        String stringValue = Integer.toString(value);
        for (char ch : stringValue.toCharArray()) {
            algorithmResult += fastPow(ch - CHAR_TO_INT_DELTA, stringValue.length());
        }
        return algorithmResult == value;
    }

    private static int fastPow(int base, int degrees) {
        long result = base;
        for (int i = 0; i < degrees - 1; i++) {
            result *= base;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }
}
