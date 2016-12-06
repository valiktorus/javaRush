package com.javarush.test.level18.lesson10.bonus02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TestRegex {
    public static void main(String[] args) {
        String s = "19846   Шорты пляжные синие           159.00  12  ";
        String s1 = "19847983Куртка для сноубордистов, разм10173.991234";
        String s2 = "198478  Шорты пляжные черные с рисунко173.00  17";
        Pattern pattern = Pattern.compile("^(\\d{1,8})\\s{0,7}(.{1,30})\\s{0,29}(\\d{1,5}\\.\\d{2})\\s{0,4}(\\d{1,4})\\s{0,3}$");
        Matcher matcher = pattern.matcher(s2);
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));
    }
}
