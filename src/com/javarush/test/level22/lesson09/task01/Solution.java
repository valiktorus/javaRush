package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            builder.append(line);
            builder.append(" ");
        }
        Set<String> set = new HashSet<>();
        StringBuilder word;
        String[] words = builder.toString().split(" ");
        for (int i = 0; i <words.length ; i++) {
            word = new StringBuilder(words[i]);
            int index = builder.indexOf(word.reverse().toString());
            if (index != -1){
                if (!set.contains(word.toString()) && !set.contains(word.reverse().toString())){
                    Pair pair = new Pair();
                    pair.first = word.toString();
                    pair.second = word.reverse().toString();
                    result.add(pair);
                    set.add(word.toString());
                }

            }
        }
        reader.close();
        for (Pair pair: result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
