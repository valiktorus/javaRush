package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        String secondFileName = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(firstFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(secondFileName);
        byte[] buffer = new byte[fileInputStream.available()];
        while (fileInputStream.available()>0){
            fileInputStream.read(buffer);
        }
        for (int i = buffer.length-1; i >=0 ; i--) {
            fileOutputStream.write(buffer[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
