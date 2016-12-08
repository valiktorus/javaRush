package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1],true));
            String line;
            int count = 0;
            try {
                while ((line = reader.readLine()) != null) {
                    count++;
                    String result = "";
                    String[] lineSplit = line.split(" ");
                    for (int i = 0; i < lineSplit.length; i++) {
                        String word = lineSplit[i];
                        if (word.matches(".*\\d.*")) {
                            result += " " + word;
                        }
                    }
                    if (count == 1) {
                        writer.write(result.trim());
                    } else {
                        writer.write(result);
                    }
                }
            }finally {
                reader.close();
                writer.close();
            }
        }
    }
}
