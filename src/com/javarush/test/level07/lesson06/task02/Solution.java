package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++){
            list.add(reader.readLine());
        }
        int max = list.get(0).length();
        int index = 0;
        for (int i = 1; i <list.size() ; i++){
            if (list.get(i).length() > max){
                max = list.get(i).length();

            }
        }

        for (String aList : list)
        {
            if (aList.length() == max)
            {
                System.out.println(aList);
            }
        }
    }
}
