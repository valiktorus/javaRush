package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter out1 = new BufferedWriter(new FileWriter(args[1]));
        while (in1.ready())
        {
            String test=in1.readLine();
            String[] arr = test.split(" ");
            for (int i = 0; i <arr.length ; i++){
                if(arr[i].length()>6){
                    if (i == arr.length-1){
                        out1.write(arr[i]);
                    }else {
                        out1.write(arr[i] + ",");
                    }
                }
            }
        }
        in1.close();
        out1.close();
    }
}
/*
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final Pattern WORD_SEPARATED_BY_SPACE = Pattern.compile("\\S{7,}");
    private static final String WORD_SEPARATOR = ",";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        Pattern pattern = WORD_SEPARATED_BY_SPACE;
        Matcher matcher = pattern.matcher(reader.readLine());
        StringBuilder builder = new StringBuilder();
        while (matcher.find()){
            builder.append(matcher.group() + WORD_SEPARATOR);
        }
        writer.write(builder.substring(0,builder.length()-1));
        reader.close();
        writer.close();
    }
}
*/
