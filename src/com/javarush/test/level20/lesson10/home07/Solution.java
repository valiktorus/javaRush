package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private String fileName;
/*    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String fileName = "c:\\1.txt";
        Solution solution = new Solution(fileName);
        solution.writeObject("test1");
        FileOutputStream fos = new FileOutputStream(fileName);
        solution.writeObject(new ObjectOutputStream(fos));
        String fileName1 = "c:\\2.txt";
        Solution solution1 = new Solution(fileName1);
        solution1.readObject(new ObjectInputStream(new FileInputStream(fileName)));
        solution1.writeObject("test2");
    }*/
    private transient FileOutputStream stream;
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }
    public Solution(){}
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeObject(fileName);
        // out.close();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
        //  in.close();
    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
