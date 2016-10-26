package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] allUrl = reader.readLine().split("\\?");
            String[] finalUrl = allUrl[1].split("&");
            ArrayList<String> obj = new ArrayList<>();
            for (int i = 0; i <finalUrl.length ; i++) {
                String[] tmp = finalUrl[i].split("=");
//                if ("obj".equals(tmp[0]) && tmp[1] != null){
//                    obj.add(tmp[1]);
                if ("obj".equals(tmp[0])){
                    obj.add(tmp[1] != null ? tmp[1] : "");
                }
                if(i != finalUrl.length-1) {
                    System.out.print(tmp[0] + " ");
                }else System.out.print(tmp[0]);
            }
            try {
                System.out.println();
                for (String list : obj) {

                    try {
                        alert(Double.parseDouble(list));
                    } catch (Exception e) {
                        alert(list);
                    }
                }
            }catch (NullPointerException e){

            }

        }catch (IOException e){

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
