package com.javarush.test.level02.lesson01.task01;

/* Реализация метода
Реализуй метод print. Метод должен вывести на экран переданную строку 4 раза. Каждый раз с новой строки.
*/
public class Solution
{
    public static void main(String[] args)
    {
        print("Java easy to learn!");
    }

    public static void print(String s)
    {
        //напишите тут ваш код
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }
}
