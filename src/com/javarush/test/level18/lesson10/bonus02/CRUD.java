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

Прайсы 2
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


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    private static final String PRODUCT_ELEMENTS_FORMAT ="%-8d%-30.30s%-8.2f%-4d";
    public static final int CREATE_ARGS_SIZE = 4;
    public static final int UPDATE_ARGS_SIZE  = 5;
    public static final int DELETE_ARGS_SIZE = 2;

    public static void main(String[] args) throws Exception {
        if (args.length == 0){return;}
        String fileName = getFileName();
        List<Product> productList = new ArrayList<>();
        if (args.length == CREATE_ARGS_SIZE &&"-c".equals(args[0])){
            productList = readProductsFromFile(fileName, productList);
            int maxId = getMaxId(productList);
            productList.add(new Product(++maxId, args[1],Double.parseDouble(args[2]),Integer.parseInt(args[3])));
            writeProductListToFile(fileName, productList);
        }else if (args.length == UPDATE_ARGS_SIZE && "-u".equals(args[0])){
                productList = readProductsFromFile(fileName, productList);
                productList = findProductByIdAndReplaceInList(productList,Integer.parseInt(args[1]),
                        args[2],Double.parseDouble(args[3]),Integer.parseInt(args[4]));
                writeProductListToFile(fileName,productList);
            }else if (args.length == DELETE_ARGS_SIZE && "-d".equals(args[0])){
                    productList = readProductsFromFile(fileName,productList);
                    productList = findProductByIdAndDeleteInList(Integer.parseInt(args[1]), productList);
                    writeProductListToFile(fileName,productList);
            }
    }

    private static String getFileName() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return  reader.readLine();
        }
    }
    private static List<Product> readProductsFromFile(String fileName, List<Product> productList) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String fileLine;
            while ((fileLine = reader.readLine()) != null) {
                Product product = makeProductFromLine(fileLine);
                productList.add(product);
            }
        }
        return productList;
    }

    private static Product makeProductFromLine(String fileLine){   // regex
        Integer id = Integer.parseInt(fileLine.substring(0,8).trim()); //trim
        String productName = fileLine.substring(8,38).trim();
        double price = Double.parseDouble(fileLine.substring(38,46).trim());
        int quantity = Integer.parseInt(fileLine.substring(46,50).trim());
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
    private static void writeProductListToFile(String fileName, List<Product> productList) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(""); //
        }
        // если здесь false поставить то каждый раз будет перезаписываться  и в итоге одна страчка будет
        try(FileWriter writer = new FileWriter(fileName, true)) {
            for (int i = 0; i <productList.size() ; i++) {
                writer.write(String.format(PRODUCT_ELEMENTS_FORMAT,
                        productList.get(i).getId(),
                        productList.get(i).getProductName(),
                        productList.get(i).getPrice(),
                        productList.get(i).getQuantity()));
                if (i != productList.size() - 1) {
                    writer.write("\n");
                }
            }
        }
    }
    private static List<Product> findProductByIdAndReplaceInList(List<Product> productList, int id,String productName,
                                                                 double price, int quantity){
        for (int i = 0; i < productList.size() ; i++) {
            if (productList.get(i).getId() == id){
                productList.set(i,new Product(id,productName,price,quantity));
            }
        }
        return productList;
    }
    private static List<Product> findProductByIdAndDeleteInList(int id, List<Product> productList){
        Integer indexOfProductToDelete = null;
        for (int i = 0; i < productList.size() ; i++) {
            if (id == productList.get(i).getId()){
                indexOfProductToDelete = i;
            }
        }
        if (indexOfProductToDelete != null){
            productList.remove((int)indexOfProductToDelete);
        }
        return productList;
    }

    public static class Product{

        private final int id;
        private  final String productName;
        private final double price;
        private final int quantity;


        public Product(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }
        public String getProductName() {
            return productName;
        }
        public double getPrice() { return price; }
        public int getQuantity() {
            return quantity;
        }

    }
}
