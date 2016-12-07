package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        String secondFileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName));
        String line;
        while ((line = reader.readLine()) != null){
            writer.write(line.replaceAll("\\.","!"));
        }
        reader.close();
        writer.close();
    }
}
