package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        boolean rule1 = telNumber.matches("^\\+d{12}");
        boolean rule2 = telNumber.matches("^[d(]");
        boolean rule3 = telNumber.matches("");
        boolean rule4 = telNumber.matches("");
        boolean rule5 = telNumber.matches("");
        boolean rule6 = telNumber.matches("");
        boolean rule7 = telNumber.matches("");
        boolean rule8 = telNumber.matches("");
        if (rule1 ||
                rule2 ||
                rule3 ||
                rule4 ||
                rule5 ||
                rule6 ||
                rule7 ||
                rule8){
            return false;
        }else {
            return true;
        }
    }
}
