package com.javarush.test.level19.lesson03.task04;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }


        @Override
        public Person read() throws IOException {
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            int day = Integer.parseInt(data[3]);
            int month = Integer.parseInt(data[4]) - 1;
            int year = Integer.parseInt(data[5]);
            Calendar calendar = new GregorianCalendar(year, month, day);
            return new Person(firstName, middleName, lastName, calendar.getTime());
        }
            /*String s = scanner.nextLine();
            Pattern pattern = Pattern.compile("^(\\D*)\\s(\\D*)\\s(\\D*)\\s(\\d*)\\s(\\d*)\\s(\\d*)$");
            Matcher matcher = pattern.matcher(s);

            String secondName = matcher.group(1);
            String name = matcher.group(2);
            String thirdName = matcher.group(3);
            int year = Integer.parseInt(matcher.group(6));
            int mounth = Integer.parseInt(matcher.group(5)) - 1;
            int day = Integer.parseInt(matcher.group(4));
            Calendar calendar = new GregorianCalendar(year, mounth, day);
            return new Person(name, secondName, thirdName, calendar.getTime());
        }*/


        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
