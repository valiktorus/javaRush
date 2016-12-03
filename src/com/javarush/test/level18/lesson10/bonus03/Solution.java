package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import javafx.print.Collation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static String fileName = null;
    public static void main(String[] args) throws IOException {
        fileName = getFileName();
        int id;
        String productName;
        double price;
        int quantity;
        if ("-u".equals(args[0])){
            id = Integer.parseInt(args[1]);
            productName = args[2];
            price = Double.parseDouble(args[3]);
            quantity = Integer.parseInt(args[4]);
            update(id,productName,price,quantity);
        }
        if ("-d".equals(args[0])){
            id = Integer.parseInt(args[1]);
            delete(id);
        }
    }
    public static String getFileName() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return  reader.readLine();
        }
    }

    public static void update(int id, String productName, double price, int quantity) throws IOException {
        String updatedLine = createUpdatedLine(id, productName, price, quantity);
        List<String> listOfLines = createListOfLines();
        findLineByIdAndReplaceInList(id, updatedLine,listOfLines);
        deleteOldDataFromFile();
        writeListToFile(listOfLines);
    }

    public static void delete(int id) throws IOException {
        List<String> listOfLInes = createListOfLines();
        listOfLInes = findLineByIdAndDeleteInList(id, listOfLInes);
        deleteOldDataFromFile();
        writeListToFile(listOfLInes);
    }

    public static String createUpdatedLine(int id, String productName, double price, int quantity){
        return String.format("%-8d%-30.30s%-8.2f%-4d",id,productName,price,quantity);
    }

    public static void findLineByIdAndReplaceInList(int id, String updatedLine, List<String> listOfLines) throws IOException {
        for (int i = 0; i < listOfLines.size() ; i++) {
            if (checkReadedLineById(id,listOfLines.get(i))){
                listOfLines.set(i,updatedLine);
            }
        }
    }

    public static boolean checkReadedLineById(int id, String readedLine){
        String idWithSpaces = readedLine.substring(0,8);
        Integer idOfLine = Integer.parseInt(idWithSpaces.split(" ")[0]);
        return  (idOfLine == id);
    }

    public static void deleteOldDataFromFile() throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
        }
    }

    public static void writeListToFile(List<String> listOfLines) throws IOException {
        try(FileWriter writer = new FileWriter(fileName)){
            for (int i = 0; i <listOfLines.size() ; i++) {
                if (i == listOfLines.size()-1) {
                    writer.write(listOfLines.get(i));
                }else {
                    writer.write(listOfLines.get(i) + System.lineSeparator());
                }
            }
        }
    }


    public static ArrayList<String> createListOfLines() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String readedLine;
            while ((readedLine = reader.readLine()) != null){
                list.add(readedLine);
                }
            return list;
        }
    }
    public static List<String> findLineByIdAndDeleteInList(int id, List<String> listOfLines) {
        Integer indexOfLineToDelete = null;
        for (int i = 0; i < listOfLines.size(); i++) {
            if (checkReadedLineById(id, listOfLines.get(i))) {
                indexOfLineToDelete = i;
            }
        }
        if (indexOfLineToDelete != null) {
            listOfLines.remove((int) indexOfLineToDelete);
            return listOfLines;
        }
        return Collections.EMPTY_LIST;
    }
}

