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
public class OldSolution {
    public static void main(String[] args) {
        int[] numbers = getNumbers(5000000);
        for (int num: numbers) {
            System.out.println(num);
        }
    }

    private static Set<Integer> resultSet = new TreeSet<>();
    public static int[] getNumbers(int N) {
        int quantityOfNumbers;
        int sum;

        for (int i = 1; i < N ; i++) {
            List<Integer> listOfInteger = getArrayOfNumbers(i);
            quantityOfNumbers = listOfInteger.size();
            sum = sumOfMultipliers(listOfInteger, quantityOfNumbers);
            resultSetFill(i,sum);
        }
        return fillResultArray();
    }

    private static List<Integer> getArrayOfNumbers(int i){
        List<Integer> list = new ArrayList<>();
        while(i > 0) {
            list.add(0,(i % 10));
            i /= 10;
        }
        return list;
    }
    private static int sumOfMultipliers(List<Integer> list,int quantityOfNumbers){
        int sum = 0;
        for (int i = 0; i < list.size() ; i++) {
            sum = sum + (int)Math.pow(list.get(i),quantityOfNumbers);
        }
        return sum;
    }
    private static void resultSetFill(int number, int sum){
        if (number == sum){
            resultSet.add(number);
        }
    }
    private static int[] fillResultArray(){
        int[] resultArray = new int[resultSet.size()];
        int i = 0;
        for (Integer number:resultSet) {
            resultArray[i] = number;
            i++;
        }
        return resultArray;
    }
}
