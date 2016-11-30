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
import java.text.DecimalFormat;

public class Solution {
    static int id = 0;
    static String fileName = null;
    public static void main(String[] args) throws Exception {
        fileName = getFileName();
        String productName = "rgawhawhwahwah";
        double price = Double.parseDouble("123");
        int quantity = Integer.parseInt("345");
        if (args[0].equals("-c")) {
            createProduct(productName, price, quantity);
        }

    }

    public static String getFileName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        return fileName;

    }
    public static void createProduct(String productName, double price, int quantity) throws IOException {
        printIdToFile(++id);
        printProductNameToFile(productName);
        printProductPriceToFile(price);
        printQuantityToFile(quantity);
    }
    public static void printIdToFile(int id) throws IOException {
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName));
        for (int i = 0; i < 8 ; i++) {
            writer.write(id);
        }
        writer.close();
    }
    public static void printProductNameToFile(String productName) throws IOException {
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName));
        byte[] buffer = new byte[60];
        buffer = productName.getBytes();
        writer.write(buffer, 0, 60);
        writer.close();
    }
    public static void printProductPriceToFile(double price) throws IOException {
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName));
        String priceString = String.format("%.2f", price);
        byte[] buffer = new byte[16];
        buffer = priceString.getBytes();
        writer.write(buffer);
        writer.close();

    }
    public static void printQuantityToFile(int quantity) throws IOException {
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName));
        for (int i = 0; i < 4 ; i++) {
            writer.write(quantity);
        }
    }
}
