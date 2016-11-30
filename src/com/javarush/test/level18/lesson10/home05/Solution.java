package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = reader.readLine();
        String secondName = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(firstName));
        String line  = in.readLine();
        in.close();
        String[] numbers = line.split(" ");

        BufferedWriter writer = new BufferedWriter(new FileWriter(secondName));

        for (String num: numbers) {
            double number = Double.parseDouble(num);
            Integer intNumber = (int)Math.round(number);
            writer.write(intNumber.toString());
            writer.write(" ");
        }
        writer.close();
    }
}
