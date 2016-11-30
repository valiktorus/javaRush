package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String key = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        if (key.equals("-e")){
            encode(fileName,fileOutputName);
        }
        if (key.equals("-d")){
            decode(fileName,fileOutputName);
        }
    }

    public static void encode(String fileName, String fileOutputName) throws IOException {
        FileInputStream fileReader = new FileInputStream(fileName);
        FileOutputStream fileWriter = new FileOutputStream(fileOutputName);
        while (fileReader.available() > 0){
            int normalElement = fileReader.read();
            fileWriter.write(normalElement + 2);
        }
        fileReader.close();
        fileWriter.close();
    }
    public static void decode(String fileName, String fileOutputName) throws IOException {
        FileInputStream fileReader = new FileInputStream(fileName);
        FileOutputStream fileWriter = new FileOutputStream(fileOutputName);
        while (fileReader.available() > 0){
            int encodedElement = fileReader.read();
            fileWriter.write(encodedElement - 2);
        }
        fileReader.close();
        fileWriter.close();
    }


}
