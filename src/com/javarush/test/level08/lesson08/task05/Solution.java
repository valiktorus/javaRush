package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
  /*  public static void main(String[] args) {
        System.out.println(createMap());
    }*/

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","2");
        map.put("3","2");
        map.put("4","2");
        map.put("5","3");
        map.put("6","4");
        map.put("7","5");
        map.put("8","6");
        map.put("9","2");
        map.put("10","2");
        removeTheFirstNameDuplicates(map);
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        Set<String> values = new HashSet<>();
        for (Map.Entry<String, String> entry : new HashMap<>(map).entrySet()) {
            String value = entry.getValue();
            if (values.contains(value)) {
                continue;
            }
            removeItemFromMapByValue(map, value);
            map.put(entry.getKey(), value);
            values.add(value);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
