package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        reader.close();
        BufferedReader inSecond = new BufferedReader(new FileReader(secondFileName));
        BufferedReader inThird = new BufferedReader(new FileReader(thirdFileName));
        BufferedWriter outFirst = new BufferedWriter(new FileWriter(firstFileName));
        int s;
        while ((s = inSecond.read()) != -1){
            outFirst.write(s);
        }
        while ((s = inThird.read()) != -1){
            outFirst.write(s);
        }
        inSecond.close();
        inThird.close();
        outFirst.close();

    }
}
