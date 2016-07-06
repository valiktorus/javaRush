package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("2", new Date("JULY 2 1988"));
        map.put("3", new Date("AUGUST 2 1988"));
        map.put("4", new Date("OCTOBER 2 1988"));
        map.put("5", new Date("SEPTEMBER 2 1988"));
        map.put("6", new Date("DECEMBER 2 1988"));
        map.put("7", new Date("MAY 2 1988"));
        map.put("8", new Date("APRIL 2 1988"));
        map.put("9", new Date("FEBRUARY 2 1988"));
        map.put("10", new Date("NOVEMBER 2 1988"));
        //напишите тут ваш код
        return  map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
      /*  for (HashMap.Entry<String, Date> pair  : map.entrySet() ) {
            String key = pair.getKey();
            Date value = pair.getValue();
            if (value.toString().contains("JUNE") || value.toString().contains("JULY") || value.toString().contains("AUGUST")){
                map.remove(key);
            }
        }*/
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Date> pair = iterator.next();
            if ((pair.getValue().getMonth() > 4) && (pair.getValue().getMonth() < 8)){
                iterator.remove();
            }
        }

    }
}
