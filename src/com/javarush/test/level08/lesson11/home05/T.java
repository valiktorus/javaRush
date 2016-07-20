package com.javarush.test.level08.lesson11.home05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Torus on 20.07.2016.
 */
public class T {

    private static final String TEST_STRING = "qweqwe qweq   qw eqw qw";

    private static final String REGEXP = "(.)((.*?)\\s+)";

    public static void main(String[] args) {
        String[] tokenArray = TEST_STRING.split(" ");
        StringBuffer result = new StringBuffer();
        for (String token : tokenArray) {
            if (token.length() > 0) {
                result.append(token.substring(0, 1).toUpperCase());
            }
            if (token.length() > 1) {
                result.append(token.substring(1));
            }
            result.append(" ");
        }
        System.out.println(result.toString());

        result = new StringBuffer();
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(TEST_STRING);
        while (matcher.find()) {
            result.append(matcher.group(1).toUpperCase());
            result.append(matcher.group(2));
        }
        System.out.println(result.toString());
    }
}
