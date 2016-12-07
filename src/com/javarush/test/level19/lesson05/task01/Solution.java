package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        String seconndFileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader reader = new FileReader(firstFileName);
        FileWriter writer = new FileWriter(seconndFileName);
        while (reader.ready()){
            reader.read();
            if (reader.ready()){
                int data = reader.read();
                writer.write(data);
            }
        }
        reader.close();
        writer.close();
    }
}
