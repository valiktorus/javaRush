package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш кодц
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        Integer array[] = {a,b,c};
        Arrays.sort(array, Collections.<Integer>reverseOrder());
        for (int i = 0; i <array.length ; i++){
            System.out.println(array[i]);
        }
    }
}
