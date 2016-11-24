package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName  =  bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Map<Integer,Integer> map = new HashMap<>();
        int key;
        int max = 0;
        while (fileInputStream.available()>0){
            key = fileInputStream.read();
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key, 1);
            }
        }
        fileInputStream.close();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if (value > max){
                max = value;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max){
                System.out.print(entry.getKey() + " ");
            }
        }

    }
}
