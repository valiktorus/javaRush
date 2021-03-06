package com.javarush.test.level22.lesson13.task03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static final String REGEX = "([+]?(\\d*?[(]\\d{3}[)])?)\\d+(((\\-\\d+){1,3})|(\\d+))";
    public static void main(String[] args) {
        String num1 = "+380501234567";
        String num2 = "+38(050)1234567";
        String num3 = "+38050123-45-67";
        String num4 = "050123-4567";
        String num5 = "+38)050(1234567";
        String num6 = "+38(050)1-23-45-6-7";
        String num7 = "050ххх4567";
        String num8 = "050123456";
        String num9 = "(0)501234567";
        System.out.println("1 - " + checkTelNumber(num1));
        System.out.println("2 - " + checkTelNumber(num2));
        System.out.println("3 - " + checkTelNumber(num3));
        System.out.println("4 - " + checkTelNumber(num4));
        System.out.println("5 - " + checkTelNumber(num5));
        System.out.println("6 - " + checkTelNumber(num6));
        System.out.println("7 - " + checkTelNumber(num7));
        System.out.println("8 - " + checkTelNumber(num8));
        System.out.println("9 - " + checkTelNumber(num9));
    }

    public static boolean checkTelNumber(String telNumber) {
        return telNumber.matches(REGEX) &&
                (telNumber.startsWith("+") && getQuantityOfNumbers(telNumber) == 12 || getQuantityOfNumbers(telNumber) == 10);

    }
    private static int getQuantityOfNumbers(String telNumber){
        return telNumber.length() - telNumber.replaceAll("\\d","").length();
    }

}
