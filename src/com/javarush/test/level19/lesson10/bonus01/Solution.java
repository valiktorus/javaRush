package com.javarush.test.level19.lesson10.bonus01;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException {
        List<String> firstList;
        List<String> secondList;
//        String firstFileName = getFileName();
//        String secondFileName  = getFileName();
        String firstFileName;
        String secondFileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        firstList = fillList(firstFileName);
        secondList = fillList(secondFileName);
        fillResultList(firstList,secondList);

    }

/*    private static String getFileName() throws IOException {
        String fileName = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }
        return fileName;
    }*/
    private static List<String> fillList(String fileName) throws IOException {
        List<String> resultList = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            resultList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                resultList.add(line);
            }
        }
        return resultList;
    }
    private static void fillResultList(List<String> firstList, List<String> secondLIst){
        for (int i = 0; i < firstList.size() ; i++) {
            String firstFileElement = firstList.get(i);
            String secondFileElement = secondLIst.get(i);
            if (firstFileElement.equals(secondFileElement)){
                lines.add(new LineItem(Type.SAME,firstFileElement));
            }else if (firstFileElement.isEmpty()){
                lines.add(new LineItem(Type.ADDED,secondFileElement));
                }else if (secondFileElement.isEmpty()){
                lines.add(new LineItem(Type.REMOVED, firstFileElement));
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
