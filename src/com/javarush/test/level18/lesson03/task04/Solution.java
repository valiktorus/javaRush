package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Map<Integer,Integer> map = new HashMap<>();
        while (fileInputStream.available()>0){
            int key = fileInputStream.read();
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else map.put(key,1);
        }
        fileInputStream.close();
        int min = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (min == 0){
                min = entry.getValue();
            }else if (entry.getValue() < min){
                min = entry.getValue();
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() == min){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
