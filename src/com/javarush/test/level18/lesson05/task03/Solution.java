package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        /* BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(firstFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(secondFileName);
        FileOutputStream fileOutputStream1 = new FileOutputStream(thirdFileName);
        int available = fileInputStream.available();
        while (fileInputStream.available() > 0){
            int input = fileInputStream.read();
            if (fileInputStream.available() > available/2) {
                fileOutputStream.write(input);
            }else {
               fileOutputStream1.write(input);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();*/


    }
}
