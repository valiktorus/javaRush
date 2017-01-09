package com.javarush.test.level22.lesson05.task01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        String line = "JavaRush - лучший сервис обучения Java.";
        String result = getPartOfString(line);
        System.out.println(result);
    }
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null){
            throw new TooShortStringException();
        }
        String[] array = string.split(" ");
        if (array.length < 5){
            throw new TooShortStringException();
        }
        String result = "";
        for (int i = 1; i <5 ; i++) {
            if (i == 4){
                result += array[i];
            }else {
                result += (array[i] + " ");
            }
        }
        return result;

       /* Pattern pattern = Pattern.compile("[^ ]+ ([^ ]+ [^ ]+ [^ ]+ [^ ]+)");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return matcher.group(1);
        }*/
       // throw new TooShortStringException();

    }

    public static class TooShortStringException extends Exception {
    }
}
