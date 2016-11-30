package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String fullFileName = null;
        Map<Integer,String> sequenceOfParts = new TreeMap<>();
        while (!(fileName = reader.readLine()).equals("end")){
            String[] parts = fileName.split(".part");
            sequenceOfParts.put(Integer.parseInt(parts[1]),fileName);
            if (fullFileName == null){
                fullFileName = parts[0];
            }
        }
        reader.close();
        new File(fullFileName).createNewFile();
        FileOutputStream writerToOriginalFile = new FileOutputStream(fullFileName);
        for (Map.Entry<Integer,String> pair: sequenceOfParts.entrySet()) {
            FileInputStream fileReader = new FileInputStream(pair.getValue());
            while (fileReader.available() > 0){
                byte[] buffer = new byte[fileReader.available()];
                fileReader.read(buffer);
                writerToOriginalFile.write(buffer);
            }
            fileReader.close();
        }
        writerToOriginalFile.close();
    }
}
