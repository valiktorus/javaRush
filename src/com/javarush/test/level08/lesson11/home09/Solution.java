package com.javarush.test.level08.lesson11.home09;

import java.util.Date;
import java.util.GregorianCalendar;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {

        isDateOdd("MAY 1 2013");
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("JANUARY 1 2000"));


    }

    public static boolean isDateOdd(String date)
    {
        Date date1 = new Date(date);
        Date date2 = new Date(date);
        date1.setMonth(0);
        date1.setDate(0);
        long timeInMiliSeconds = date2.getTime() - date1.getTime();
        int time = (int) timeInMiliSeconds/(1000*60*60*24);
        return time%2 != 0;
    }
}
