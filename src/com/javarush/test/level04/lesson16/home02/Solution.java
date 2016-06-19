package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int a =scanner.nextInt();
        int b =scanner.nextInt();
        int c =scanner.nextInt();
       /* int array[] = {a,b,c};*/
        if (a < Math.max(b,c) && a > Math.min(b,c)){
            System.out.println(a);
        } else {
            if (b < Math.max(a,c) && b > Math.min(a,c)){
                System.out.println(b);
            }else {
                System.out.println(c);
            }
        }


    }
}
