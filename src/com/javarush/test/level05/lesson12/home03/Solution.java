package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код
        Dog dog = new Dog("Dog", 12, 13);
        Cat cat = new Cat("Tom", 17, 17);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
    public static class Dog{
        private String name;
        private int weight;
        private int length;

        public Dog(String name, int weight, int length){
            this.name = name;
            this.weight = weight;
            this.length = length;
        }
    }
    public static class Cat{
        private String name;
        private int weight;
        private int length;

        public Cat(String name, int weight, int length){
            this.name = name;
            this.weight = weight;
            this.length = length;
        }

    }

}
