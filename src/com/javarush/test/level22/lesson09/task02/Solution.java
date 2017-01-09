package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
/*    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("3","6");
        map.put("4","7");
        map.put("15",null);
        StringBuilder res = getCondition(map);
        System.out.println(res);

    }*/

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<String,String> pair: params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (value != null){
                if (!result.toString().equals("")){result.append(" and ");}
                result.append(key);
                result.append(" = '");
                result.append(value);
                result.append("'");
            }
        }
        return result;
    }
}
