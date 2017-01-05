package com.javarush.test.level20.lesson10.bonus01;

import java.util.*;

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
public class NewSolution {
    private static final int COMPARE_MAX_VALUE = 999999999;
    private static final int MILLISECONDS = 1000;
    private static int armstrongNumber;
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        int[] numbers = getNumbers(COMPARE_MAX_VALUE);
        long endTime = new Date().getTime();
        System.out.println("Total (sec): " + (endTime - startTime) / MILLISECONDS);
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory " + memory / 1048576);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static int[] getNumbers(int N) {
        Set<Integer> set = new TreeSet<>();
        int[][] arrayOfMultipliers = getArrayOfMultipliers();
        for (int i = 1; i < N ; i++) {
            if (isNumberUnique(i)){
                int countOfNumbers = getCountOfNumbers(i);
                int[] arrayOfNumbers = getArrayOfNumbers(i,countOfNumbers);
                if (findArmstrongNumber(countOfNumbers, arrayOfNumbers,arrayOfMultipliers)){
                    set.add(armstrongNumber);
                }
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getCountOfNumbers(int number){
        if (number >= 1 && number < 10){
            return 1;
        }else if (number >= 10 && number < 100){
            return 2;
        }else if (number >= 100 && number < 1000){
            return 3;
        }else if (number >= 1_000 && number < 10_000){
            return 4;
        }else if (number >= 10_000 && number < 100_000){
            return 5;
        }else if (number >= 100_000 && number < 1_000_000){
            return 6;
        }else if (number >= 1_000_000 && number < 10_000_000){
            return 7;
        }else if (number >= 10_000_000 && number < 100_000_000){
            return 8;
        }else if (number >= 1_000_000_000){
            return 9;
        }else return 0;
    }

    private static int[][] getArrayOfMultipliers(){
        int[][] result = new int[10][10];
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                result[i][j] = fastPow(i,j);
            }
        }
        return result;
    }

    private static int fastPow(int firstNum, int secondNum){
        int result = 1;
        for (int i = 0; i <secondNum ; i++) {
            result *=firstNum;
        }
        return result;
    }
    private static boolean isNumberUnique(int number){
        int lastElement;
        int currentElement;
        lastElement = number % 10;
        number /= 10;
        while (number > 0){
            currentElement = number % 10;
            if (currentElement == 0){
                return true;
            }
            if (currentElement > lastElement){
                return false;
            }else {
                lastElement = currentElement;
                number /= 10;
            }
        }
        return true;

    }
    private static int[] getArrayOfNumbers(int number, int countOfNumbers){
        int[] result = new int[countOfNumbers];
        for (int i = countOfNumbers-1; i >= 0 ; i--) {
            result[i] = number % 10;
            number /= 10;
        }
        return result;
    }

    private static boolean findArmstrongNumber(int countOfNumbers, int[] arrayOfNumbers,
                                               int[][] arrayOfMultipliers){
        int sum = 0;
        for (int i = 0; i < arrayOfNumbers.length ; i++) {
            sum += arrayOfMultipliers[arrayOfNumbers[i]][countOfNumbers];
        }
        int countOfNumbersOfSum = getCountOfNumbers(sum);
        if (isArmstrongNumber(sum, countOfNumbersOfSum,getArrayOfNumbers(sum, countOfNumbersOfSum),
                arrayOfMultipliers)){
        armstrongNumber = sum;
            return true;
        }
        return false;
    }
    private static boolean isArmstrongNumber(int number,int countOfNumbers, int[] arrayOfNumbers,
                                               int[][] arrayOfMultipliers){
        int sum = 0;
        for (int i = 0; i < arrayOfNumbers.length ; i++) {
            sum += arrayOfMultipliers[arrayOfNumbers[i]][countOfNumbers];
        }
        return number == sum;
    }
}
