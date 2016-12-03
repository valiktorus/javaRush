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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static final String PRODUCT_ELEMENTS_FORMAT ="%-8d%-30.30s%-8.2f%-4d";
    private static List<Product> productList = Collections.emptyList();
    public static void main(String[] args) throws Exception {
        String fileName = getFileName();
        args = new String[4];
        args[0] = "-c";
        args[1] = "kkfya vfjyav";
        args[2] = "141.88";
        args[3] = "123";
        if ("-c".equals(args[0])){
            productList = readProductsFromFile(fileName);
            int maxId = getMaxId(productList);
            productList.add(new Product(++maxId, args[1],Double.parseDouble(args[2]),Integer.parseInt(args[3])));
            writeProductListToFile(fileName);
        }
    }

    private static String getFileName() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return  reader.readLine();
        }
    }
    private static List<Product> readProductsFromFile(String fileName) throws IOException {
        List<Product> productList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String fileLine;
            while ((fileLine = reader.readLine()) !=null){
                productList.add(makeProductFromLine(fileLine));
            }
        }
        return productList;
    }
    private static Product makeProductFromLine(String fileLine){
        int id = Integer.parseInt(fileLine.substring(0,8).split(" ")[0]);
        String productName = fileLine.substring(8,38);
        double price = Double.parseDouble(fileLine.substring(38,46).split(" ")[0]);
        int quantity = Integer.parseInt(fileLine.substring(46,50).split(" ")[0]);
        return new Product(id,productName,price,quantity);

    }

    private static int getMaxId(List<Product> productList){
        int maxId = 0;
        for (Product product: productList) {
            int productId = product.getId();
            if (productId > maxId){
                maxId = productId;
            }
        }
        return maxId;
    }
    private static void writeProductListToFile(String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
        }
        try(FileWriter writer = new FileWriter(fileName, true)) {
            for (int i = 0; i <productList.size() ; i++) {
                if (i == productList.size() - 1) {
                    writer.write(String.format(PRODUCT_ELEMENTS_FORMAT,
                            productList.get(i).getId(),
                            productList.get(i).getProductName(),
                            productList.get(i).getPrice(),
                            productList.get(i).getQuantity()));
                }else {
                    writer.write(String.format(PRODUCT_ELEMENTS_FORMAT + "\n",
                            productList.get(i).getId(),
                            productList.get(i).getProductName(),
                            productList.get(i).getPrice(),
                            productList.get(i).getQuantity()));
                }
            }
        }
    }

    public static class Product{

        private int id;
        private String productName;
        private double price;
        private int quantity;


        public Product(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return Double.parseDouble(String.valueOf(price).replace(",","."));
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
