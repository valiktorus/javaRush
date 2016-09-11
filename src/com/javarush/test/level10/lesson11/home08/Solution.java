package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add("1");
        }
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list1.add("2");
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list2.add("3");
        }
            ArrayList<String>[] arrayLists = new ArrayList[3];
            arrayLists[0] = list;
            arrayLists[1] = list1;
            arrayLists[2] = list2;
            return arrayLists;
    }


    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}