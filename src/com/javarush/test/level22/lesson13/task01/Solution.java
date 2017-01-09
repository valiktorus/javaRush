package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
   /* public static void main(String[] args) {
        String[] line = getTokens("level22.lesson13.task01", ".");
        for (String word: line) {
            System.out.println(word);
        }
    }*/
    public static String [] getTokens(String query, String delimiter) {
        String[] result;
        List<String> list = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        result = new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
