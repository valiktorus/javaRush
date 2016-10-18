package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        Scanner scanner = new Scanner(inputStream);
        Set<Integer> set = new TreeSet<>();
        while (scanner.hasNext()){
            int tmp = scanner.nextInt();
            if (tmp % 2 == 0)set.add(tmp);
        }
        for (Integer integ:set) {
            System.out.println(integ);
        }
    }
}
