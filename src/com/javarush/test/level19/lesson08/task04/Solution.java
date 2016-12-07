package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String line = outputStream.toString();
        String[] elements = line.split(" ");
        int firstNum = Integer.parseInt(elements[0]);
        String calculation = elements[1];
        System.setOut(consoleStream);
        int secondNum = Integer.parseInt(elements[2]);
        int result = 0;
        if ("+".equals(calculation)){
            result = firstNum + secondNum;
            System.out.println(firstNum + " + " + secondNum + " = " + result);
        }
        if ("-".equals(calculation)){
            result = firstNum - secondNum;
            System.out.println(firstNum + " - " + secondNum + " = " + result);}
        if ("*".equals(calculation)){
            result = firstNum * secondNum;
            System.out.println(firstNum + " * " + secondNum + " = " + result);
        }




    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

