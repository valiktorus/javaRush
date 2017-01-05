package com.javarush.test.level20.lesson10.bonus01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (int)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Test {
    static long[][] num;//Массив цифр в разных степенях
    static { num = new long[12][10];
        num[0][0] = 0L;num[0][1] = 1L;num[0][2] = 2L;
        num[0][3] = 3L;num[0][4] = 4L;num[0][5] = 5L;
        num[0][6] = 6L;num[0][7] = 7L;num[0][8] = 8L;
        num[0][9] = 9L;
        for (int i = 1; i < 12; i++) {//Заполнение массива
            for (int j = 0; j < 10; j++) {
                num[i][j] = num[i - 1][j] * num[0][j];
            }
        }
    }
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        getNumbers(Integer.MAX_VALUE);
        long timeEnd = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().totalMemory();
        long memoryEnd = Runtime.getRuntime().freeMemory();

        System.out.println(timeEnd - timeStart + "ms");
        System.out.println((memoryStart - memoryEnd) / 1024 + "kb");

    }

    public static int[] getNumbers(int N) {

        int[] result = null;//массив результата
        ArrayList<Long> list = new ArrayList<>();//временное хранилище чисел Армстронга
        list.add(0L);//0 добавляю сразу
        long sum = 0L;
        long sum10 = 0L;
        long sum100 = 0L;
        long temp1 = 0L;//переменная для перебора чисел
        long prtemp1 = 0L;
        String str = new String();
        cat:
        {
            while (true) {
                sum = 0L;//сумма цифр числа в степени обнуляется
                sum10 = 0L;//сумма цифр числа с 0 в степени обнуляется
                sum100 = 0L;//сумма цифр числа с 00 в степени обнуляется
                cat1:
                {
                    if (temp1 % 10 != 9) temp1 = temp1 + 1L;
                    else {
                        str = "";
                        prtemp1 = temp1 / 10 + 1L;

                        while (prtemp1 % 10 == 0) {
                            prtemp1 = prtemp1 / 10;
                        }
                        str = str.concat(prtemp1 + "");
                        while (str.length() < (temp1 + "").length()) {
                            str = str.concat(prtemp1 % 10 + "");
                        }
                        if ((temp1 + "").length() != (temp1 + 1 + "").length()) str = str.concat(prtemp1 % 10 + "");
                        temp1 = Long.parseLong(str);
                    }
                    sum = getSum(temp1);
                    if ((temp1+"").length() <= ((N+"").length()-1) && sum < N && (temp1+"").length() <= 8) {
                        sum10 = getSum10(temp1);
                    }
                    if ((temp1+"").length() <= ((N+"").length()-2)&& sum10 < N && sum10!=0L && (temp1+"").length() <= 7) {
                        sum100 = getSum100(temp1);
                    }
                    if (temp1 > N) {
                        break cat;
                    } else if (sum == getSum(sum) && (sum + "").length() == (temp1 + "").length() && sum < N) {
                        list.add(sum);
                    } else if (sum10 > N || sum10 == 0L) {
                        break cat1;
                    } else if (sum10 == getSum(sum10) && !list.contains(sum10)&& sum10 < N) {
                        list.add(sum10);
                    } else if (sum100 > N || sum100 == 0L) {
                        break cat1;
                    } else if (sum100 == getSum(sum100) && !list.contains(sum100)&& sum100 < N) {
                        list.add(sum100);
                    }
                }
            }
        }
        Collections.sort(list);
        if (list.size()>0)
        {result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = Integer.parseInt(list.get(i)+"");
                System.out.println(result[i]);
            }
        }
        return result;
    }
    public static long getSum(long next){//расчёт суммы цифр числа в степени
        long sum1 = 0;
        String temp = (next + "");
        for (int i = 0; i < temp.length(); i++) {
            sum1 += Test.num[temp.length() - 1][Integer.parseInt(temp.charAt(i) + "")];
        }
        return sum1;
    }
    public static long getSum10(long next){//расчёт суммы цифр числа с 0 в степени
        long sum2 = 0;
        String temp = (next + "");
        for (int i = 0; i < temp.length(); i++) {
            sum2 += Test.num[temp.length()][Integer.parseInt(temp.charAt(i) + "")];
        }
        return sum2;
    }
    public static long getSum100(long next){//расчёт суммы цифр числа с 00 в степени
        long sum3 = 0;
        String temp = (next + "");
        for (int i = 0; i < temp.length(); i++) {
            sum3 += Test.num[temp.length() + 1][Integer.parseInt(temp.charAt(i) + "")];
        }
        return sum3;
    }
}