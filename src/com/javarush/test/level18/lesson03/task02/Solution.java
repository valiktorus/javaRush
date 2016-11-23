package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        int min;
        int a;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        min = fileInputStream.read();
        while (fileInputStream.available()>0){
            a = fileInputStream.read();
            if (a < min){
                min = a;
            }
        }
        fileInputStream.close();
        System.out.println(min);
    }
}
