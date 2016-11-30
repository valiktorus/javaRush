package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //       BufferedReader reader = new BufferedReader(new FileReader("d:/1.txt"));
        FileInputStream reader = new FileInputStream(args[0]);
        Map<Integer,Integer> map = new TreeMap<>();
        int simbol;
        while (reader.available()>0){
            simbol = reader.read();
            if (map.containsKey(simbol)){
                map.put(simbol,map.get(simbol)+1);
            }else map.put(simbol,1);
        }
        reader.close();
        for (Map.Entry<Integer,Integer> pair: map.entrySet()) {
            System.out.println((char)(int)pair.getKey() + " " + pair.getValue());
        }


    }
}
/*import java.io.FileInputStream;
import java.io.IOException;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int[] symbCountArr = new int[256];
            while (fileInputStream.available() > 0)
            {
                int ch = fileInputStream.read();
                symbCountArr[ch]++;
            }
            //symbCountArr[10] = 0; - обнуление 10ого символа не помогает, в коде строка отсутствует
            for (int i = 0; i < symbCountArr.length; i++)
            {
                if (symbCountArr[i] != 0){
                    System.out.println((char)i + " " + symbCountArr[i]);}
            }
            fileInputStream.close();
    }
}*/



/**/
