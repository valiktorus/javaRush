package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] spacebarByte = " ".getBytes();
        int intSpacebarByte = spacebarByte[0];
        int spaces = 0;
        int simbols = fileInputStream.available();
        while (fileInputStream.available()>0){
            if (fileInputStream.read() == intSpacebarByte){
                spaces++;
            }
        }
        fileInputStream.close();
        System.out.println(new DecimalFormat("#0.00").format((double)spaces/simbols*100));



/*        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/1.tmp"));
        String line;
        int countOfSimbols = 0;
        int countOfSpacebar = 0;
        while ((line = bufferedReader.readLine()) != null){
            char[] chars = line.toCharArray();
            countOfSimbols += chars.length;
            for (char element: chars) {
                if (element == ' '){
                    countOfSpacebar++;
                }
            }
        }
        bufferedReader.close();
        System.out.println(new DecimalFormat("#0.00").format((double) (countOfSpacebar * 100)/countOfSimbols));*/
    }
}
