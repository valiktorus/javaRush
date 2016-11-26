package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream;
        try {
            while ((inputStream = new FileInputStream(bufferedReader.readLine())).available() >=1000){
            }
            bufferedReader.close();
            inputStream.close();
            throw new DownloadException();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception{

    }
}
