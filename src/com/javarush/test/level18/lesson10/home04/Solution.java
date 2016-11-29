package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(firstFileName);
        byte[] buf = new byte[fileInputStream.available()];
        fileInputStream.read(buf);
        fileInputStream.close();

        FileInputStream fileInputStream1 = new FileInputStream(secondFileName);
        byte[] buf1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(buf1);
        fileInputStream1.close();

        FileOutputStream fileOutputStream = new FileOutputStream(firstFileName);
        fileOutputStream.write(buf1);
        fileOutputStream.flush();
        fileOutputStream.write(buf);
        fileOutputStream.close();
    }
}
