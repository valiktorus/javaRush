package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String s = "";
        while(file.ready())
        {
            s = s + file.readLine();
        }
        String[] words = s.split(" ");
        reader.close();
        file.close();
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }
    public static StringBuilder getLine(String... words)
    {
        if(words.length==0) return null;
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        int count = 0;
        StringBuilder s = null;
        while(count != list.size())
        {
            count = 1;
            Collections.shuffle(list);
            s = new StringBuilder(list.get(0));
            for(int i = 0; i < list.size()-1; i++)
            {
                if (list.get(i) != null) {
                    if (list.get(i).toLowerCase().charAt(list.get(i).length() - 1) == list.get(i + 1).toLowerCase().charAt(0)) {
                        if (count ==0) {
                            s.append(list.get(i + 1));
                            count++;
                        }else {
                            s.append(" " + list.get(i + 1));
                            count++;
                        }
                    }
                }
            }
        }
        return s;
    }
}
/*public class Solution {
    public static ArrayList<String> list = new ArrayList<>();
    public static int num = 0;
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       String fileName = bufferedReader.readLine();
 //       bufferedReader.close();
        BufferedReader reader = new BufferedReader(new FileReader("e:\\java\\projects\\javaRush\\src\\com\\javarush\\test\\level22\\lesson09\\task03\\1.txt"));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null){
            builder.append(line);
        }
        reader.close();
        String[] words = builder.toString().split(" ");
        StringBuilder result = getLine(words);
        //...

        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        Set<String> set =new TreeSet<>(new MyComp());
        for (String word: words) {
            set.add(word);
        }
        num = 1;
        for (String word: list) {
            set.add(word);
        }
        StringBuilder builder = new StringBuilder("");
        for (String word:set) {
            if (builder.toString().equals("")){
                builder.append(word);
            }else {
                builder.append(" ");
                builder.append(word);
            }
        }
          return builder;
    }
    public static class MyComp implements Comparator<String>{

        @Override
        public int compare(String firstString, String secondString) {
            firstString = firstString.toLowerCase();
            secondString = secondString.toLowerCase();
            if (firstString.toCharArray()[firstString.toCharArray().length-1] == secondString.toCharArray()[0]){
                return -1;
            }else if (secondString.toCharArray()[secondString.toCharArray().length-1] == firstString.toCharArray()[0]){
                return +1;
            }else {
                if(num == 0){list.add(firstString);}

                return 0;
            }
        }
    }
}*/
