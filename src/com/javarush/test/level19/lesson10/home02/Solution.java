package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String,Double> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] lineSplit = line.split(" ");
            String key = lineSplit[0];
            double value = Double.parseDouble(lineSplit[1]);
            if (map.containsKey(key)){
                map.put(key, map.get(key) + value);
            }else {
                map.put(key, value);
            }
        }
        bufferedReader.close();
        double max = 0;
        for (Map.Entry<String,Double> pair:map.entrySet()) {
            if (pair.getValue() > 0){
                max = pair.getValue();
            }
        }
        for (Map.Entry<String,Double> pair : map.entrySet()) {
            if (pair.getValue() == max){
                System.out.println(pair.getKey());
            }
        }
    }
}
