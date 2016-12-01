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
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class Solution {
    static int id = 12516;
    static String fileName = null;
    public static void main(String[] args) throws Exception {
        fileName = getFileName();
        id = 19847983;
        String productName = "Куртка для сноубордистов, размера";
        double price = Double.parseDouble("10173.99");
        int quantity = Integer.parseInt("1234");

        createProduct(productName, price, quantity);

    }

    public static String getFileName() throws IOException {
       try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           return  reader.readLine();
       }

    }
    public static void createProduct(String productName, double price, int quantity) throws IOException {
        printIdToFile(++id);
        printProductNameToFile(productName);
        printProductPriceToFile(price);
        printQuantityToFile(quantity);
    }
    public static void printIdToFile(Integer id) throws IOException {
        try(RandomAccessFile file = new RandomAccessFile(fileName,"rw")) {
            file.skipBytes((int) file.length());
            char[] idCharArray = id.toString().toCharArray();

            for (int i = 0; i < 8; i++) {
                if (i <= idCharArray.length - 1) {
                    file.write(idCharArray[i]);
                } else {
                    file.write(" ".getBytes());
                }
            }
        }

    }
    public static void printProductNameToFile(String productName) throws IOException {
        try(RandomAccessFile file = new RandomAccessFile(fileName,"rw")) {
            file.skipBytes((int) file.length());
            char[] productNameChar = productName.toCharArray();
            for (int i = 0; i < 30; i++) {
                if (i <= productNameChar.length - 1) {
                    file.write(productNameChar[i]);
                } else {
                    file.write(" ".getBytes());
                }
            }
        }
    }
    public static void printProductPriceToFile(double price) throws IOException {
        try(RandomAccessFile file = new RandomAccessFile(fileName,"rw")){
            file.skipBytes((int) file.length());
            String priceString = String.format("%.2f", price);
            char[] priceChars = priceString.toCharArray();
            for (int i = 0; i <8 ; i++) {
                if (i <= priceChars.length - 1){
                    file.write(priceChars[i]);
                }else {
                    file.write(" ".getBytes());
                }
            }
        }

    }
    public static void printQuantityToFile(Integer quantity) throws IOException {
        try(RandomAccessFile file = new RandomAccessFile(fileName,"rw")) {
            file.skipBytes((int) file.length());
            char[] quantityChar = quantity.toString().toCharArray();
            for (int i = 0; i < 4; i++) {
                if (i <= quantityChar.length - 1) {
                    file.write(quantityChar[i]);
                } else {
                    file.write(" ".getBytes());
                }
            }
        }
    }
}
