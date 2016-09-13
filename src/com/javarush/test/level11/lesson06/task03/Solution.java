package com.javarush.test.level11.lesson06.task03;

/* В гостях у бабушки
Написать шесть классов: Animal (животное), Cow(корова) и Pig(свинья), Sheep(овца), Bull(бык), Goat(козел).
Унаследовать корову, свинью, овцу, быка и козла от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Animal
    {
        int size;
        String name;
        String sound;
    }

    public class Cow extends Animal
    {
        int numberOfGrass;
    }

    public class Pig extends Animal
    {
        int numberOfLittlePigs;
    }

    public class Sheep extends Animal
    {
        int numberOfLittleSheeps;
    }

    public class Bull extends Animal
    {
        int numberOfLittleBull;
    }

    public class Goat extends Animal
    {
        int numberOfLittleGoat;
    }

}
