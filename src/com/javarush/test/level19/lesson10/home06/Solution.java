package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources
Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.
Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/
public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static
    {
        map.put(12,"двенадцать");
        map.put(11,"одинадцать");
        map.put(10,"десять");
        map.put(9,"девять");
        map.put(8,"восемь");
        map.put(7,"семь");
        map.put(6,"шесть");
        map.put(5,"пять");
        map.put(4,"четыре");
        map.put(3,"три");
        map.put(2,"два");
        map.put(1,"один");
        map.put(0,"ноль");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufreader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufreader.readLine();
        bufreader.close();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.ready()){
            String line=reader.readLine();
            String[] data = line.split(" ");
            for (int d =0;d<data.length;d++){
                try
                {
                    for (Map.Entry<Integer,String> k:map.entrySet()){
                        if(k.getKey()==Integer.parseInt(data[d]))
                            data[d]=new String(k.getValue().getBytes(),"utf8");
                    }
                }catch (NumberFormatException e){
                }
                line="";
                for (String v:data){
                    line=line+v+" ";
                }
            }
            line=line.substring(0,line.lastIndexOf(" "));
            System.out.println(line);
        }
        reader.close();
    }
}
/*
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

*//* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*//*

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null){

            for (int i = 0; i <13 ; i++) {
                line = line.replaceAll(("\\W(i)\\W")," " + map.get(i) + " ");
            }
            System.out.println(line);

        }
        reader.close();

    }
}*/
