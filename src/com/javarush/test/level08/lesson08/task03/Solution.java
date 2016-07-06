package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("3","4");
        map.put("5","6");
        map.put("15","6");
        map.put("7","8");
        map.put("9","10");
        map.put("17","11");
        map.put("12","6");
        map.put("16","13");
        map.put("14","4");
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (String tmp: map.values()) {
            if (name.equals(tmp)){
                count++;
            }
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        return map.containsKey(lastName) ? 1 : 0;

    }
}
