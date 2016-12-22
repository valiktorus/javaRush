package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        InputStream inputStream = new FileInputStream(fileName);
        new Solution().load(inputStream);
        inputStream.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String,String> pair:properties.entrySet()) {
            prop.setProperty(pair.getKey(),pair.getValue());
        }
        prop.store(outputStream,null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties1 = new Properties();
        properties1.load(inputStream);
        Set<Object> set = properties1.keySet();
        for (Object key: set) {
            String keyString = (String)key;
            properties.put(keyString,properties1.getProperty(keyString));
        }


    }
}
