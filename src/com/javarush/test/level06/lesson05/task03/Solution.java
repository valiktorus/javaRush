package com.javarush.test.level06.lesson05.task03;

/* По 50 000 объектов Cat и Dog
Создать в цикле по 50 000 объектов Cat и Dog. (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
      /*  Cat[] arrayCat = new Cat[50000];
        for (int i = 0; i <50000 ; i++)
        {
            arrayCat[i] = new Cat();
        }
        Dog[] arrayDog = new Dog[50000];
        for (int i = 0; i <50000 ; i++)
        {
            arrayDog[i] = new Dog();
        }*/
        for (int i = 0; i <50000 ; i++)
        {
            Cat cat = new Cat();
        }
        for (int i = 0; i <50000 ; i++)
        {
            Dog dog = new Dog();
        }

    }
}
class Cat
{
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Cat destroyed");
    }
}

class Dog
{
    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
        System.out.println("Dog destroyed");
    }
}