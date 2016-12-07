package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/



import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter("[\\s\\p{Punct}]");
        int count = 0;
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.equals("world")) {
                count++;
            }
        }
        scanner.close();
        System.out.println(count);
    }
}