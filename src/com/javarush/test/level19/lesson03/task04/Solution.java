package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        @Override
        public Person read() throws IOException {
            String s = scanner.nextLine();
            Pattern pattern = Pattern.compile("^(\\w)*\\s(\\w)*\\s(\\w)*\\s([\\d*\\s*])$");
            Matcher matcher = pattern.matcher(s);


            return new Person();
        }

        @Override
        public void close() throws IOException {

        }
    }
}
