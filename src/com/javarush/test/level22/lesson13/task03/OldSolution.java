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
public class OldSolution {
    public static void main(String[] args) {
        String num1 = "+380501234567";
        String num2 = "+38(050)1234567";
        String num3 = "+38050123-45-67";
        String num4 = "050123-4567";
        String num5 = "+38)050(1234567";
        String num6 = "+38(050)1-23-45-6-7";
        String num7 = "050ххх4567";
        String num8 = "050123456";
        String num9 = "(0)501234567";
        System.out.println("1 - " + checkTelNumber(num1));
        System.out.println("2 - " + checkTelNumber(num2));
        System.out.println("3 - " + checkTelNumber(num3));
        System.out.println("4 - " + checkTelNumber(num4));
        System.out.println("5 - " + checkTelNumber(num5));
        System.out.println("6 - " + checkTelNumber(num6));
        System.out.println("7 - " + checkTelNumber(num7));
        System.out.println("8 - " + checkTelNumber(num8));
        System.out.println("9 - " + checkTelNumber(num9));
    }

    public static boolean checkTelNumber(String telNumber) {

        boolean plus = checkNumberByPlus(telNumber);
        boolean numbers = checkQuantityIfStartsWithNumberOrParenthesis(telNumber);
        boolean minus = checkNumberByMinus(telNumber);
        boolean parenthesis = checkNumberByParenthesis(telNumber);
        boolean chars = checkNumberByChar(telNumber);
        boolean numberFinish = checkNumberByFinalSymbol(telNumber);

        return plus && numbers && minus && parenthesis && chars && numberFinish;
    }
    private static boolean checkNumberByParenthesis(String telNumber){
        if (telNumber.contains("(")){
            if (!telNumber.contains(")")){
                return false;
            }else {
                return telNumber.matches("^[+\\d]?\\d*\\(\\d{3}\\)[^\\(^\\)]+$");
            }
        }
        return true;
    }

    private static int getQuantityOfNumbers(String telNumber){
        return telNumber.length() - telNumber.replaceAll("\\d","").length();
    }

    private static boolean checkNumberByPlus(String telNumber){
        if (telNumber.contains("+")) {
            return telNumber.matches("^\\+.+") && 12 == getQuantityOfNumbers(telNumber);
        }
        return true;
    }

    private static boolean checkQuantityIfStartsWithNumberOrParenthesis(String telNumber){
        if (telNumber.matches("^\\(.*") || telNumber.matches("^\\d.*")){
            return 10 == getQuantityOfNumbers(telNumber);
        }
        return true;
    }

    private static boolean checkNumberByMinus(String telNumber){
        if (telNumber.contains("-")){
            boolean rule3Reverse = telNumber.matches("--");
            boolean rule3 = telNumber.matches("^[^a-z^A-Z-]+-\\d+-[^a-z^A-Z-]+$");
            boolean rule3ToOneMinus = telNumber.matches("^[^a-z^A-Z-]+-[^a-z^A-Z-]+$");
            if (rule3Reverse){
                return false;
            }else return rule3 || rule3ToOneMinus;
        }
        return true;
    }

    private static boolean checkNumberByChar(String telNumber){
        return telNumber.length() - telNumber.replaceAll("[a-zA-Zа-яА-Я]","") .length() == 0;
    }

    private static boolean checkNumberByFinalSymbol(String telNumber){
        return telNumber.matches(".*\\d$");
    }
}
