package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileReader = new FileInputStream(args[0]);
        int counter = 0;
        while ((fileReader.available()>0)){
            int readenByte = fileReader.read();
            if ((readenByte >= 65 && readenByte<=90) || (readenByte >= 97 && readenByte <=122)){
                counter++;
            }
        }
        System.out.println(counter);
        fileReader.close();
    }
}
