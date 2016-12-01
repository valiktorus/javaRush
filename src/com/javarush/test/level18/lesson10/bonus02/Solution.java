package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    static int id;
    static String fileName = null;
    public static void main(String[] args) throws Exception {
        fileName = getFileName();
        id = 0;
        if ("-c".equals(args[0])) {
            String productName = args[1];
            double price = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);
            createProduct(productName, price, quantity);
        }
    }

    public static String getFileName() throws IOException {
       try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           return  reader.readLine();
       }
    }

    public static void createProduct(String productName, double price, int quantity) throws IOException {
        writeIdToFile(++id);
        writeProductNameToFile(productName);
        writeProductPriceToFile(price);
        writeQuantityToFile(quantity);
    }

    public static void writeIdToFile(Integer id) throws IOException {
        try(FileWriter writer = new FileWriter(fileName, true)) {
 //           if (id != 1){writer.write(System.lineSeparator());}
            writer.write(String.format("%-8.8s", id));
        }
    }
    public static void writeProductNameToFile(String productName) throws IOException {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("%-30.30s", productName));
        }
    }
    public static void writeProductPriceToFile(double price) throws IOException {
        try(FileWriter writer = new FileWriter(fileName, true)){
             writer.write(String.format("%-8.2f", price).replace(',','.'));
        }
    }
    public static void writeQuantityToFile(Integer quantity) throws IOException {
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("%-4.4s", quantity));
        }
    }
}
