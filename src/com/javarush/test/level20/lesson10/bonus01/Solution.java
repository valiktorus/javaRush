package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
public class Solution {
    public static int[] getNumbers(int N) {
        int S;
        int M;
        Set<Integer> resultSet = new TreeSet<>();
        for (int i = 1; i < N ; i++) {
            M = (int) Math.ceil(Math.log10(i + 0.5));
            List<Integer> arrayOfInteger = getArrayOfNumbers(i);
            if (i == Math.pow(arrayOfInteger.get(0),M));
        }
        int[] result = null;
        return result;
    }
    public static List<Integer> getArrayOfNumbers(int i){
        List<Integer> list = new ArrayList<>();
        while(i > 0) {
            list.add(0,(i % 10));
            i /= 10;
        }
        return list;
    }
}
