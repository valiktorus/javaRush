package com.javarush.test.level11.lesson06.task01;

/* Лошадь и пегас
Написать два класса: Horse (лошадь) и Pegas (пегас).
Унаследовать пегаса от лошади.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Horse
    {
        public String name;

    }

    public class Pegas extends Horse
    {
        public int wings;
    }
}
