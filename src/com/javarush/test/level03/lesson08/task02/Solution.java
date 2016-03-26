package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String name;
        int number1;
        int number2;
        name = scanner.nextLine();
        if (scanner.hasNextInt()){
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();
            System.out.println(name + " получает " + number1 + " через " + number2 + " лет.");
        }else {
            System.out.println("ввели бред!!!");
        }


    }
}