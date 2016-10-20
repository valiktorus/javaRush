package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(reader.readLine());
        int secondNum = Integer.parseInt(reader.readLine());
        System.out.println(separator(firstNum,secondNum));
    }
    public static int separator(int firstNum, int secondNum){
        int min = Math.min(firstNum,secondNum);
        int max = Math.max(firstNum,secondNum);
        for (int i = min; i > 0 ; i--) {
            if (min % i == 0 && max % i == 0){
                return i;
            }
        }
        return 1;
    }
}
