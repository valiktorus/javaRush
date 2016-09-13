package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код

        ArrayList<Human> list1 = new ArrayList<>();

        Human children1 = new Human("children1", true, 20, list1);
        Human children2 = new Human("children2", true, 20, list1);
        Human children3 = new Human("children3", true, 20, list1);
        ArrayList<Human> childrenList = new ArrayList<>();
        childrenList.add(children1);
        childrenList.add(children2);
        childrenList.add(children3);
        Human dad = new Human("dad", true, 40,childrenList);
        Human mom = new Human("mom", false, 42,childrenList);
        ArrayList<Human> dadMom =new ArrayList<>();
        dadMom.add(dad);
        dadMom.add(mom);

        Human ded1 = new Human("ded1", true, 72,dadMom);
        Human baba1 = new Human("baba1", false, 72,dadMom);
        Human ded2 = new Human("ded2", true, 72,dadMom);
        Human baba2 = new Human("baba2", false, 72,dadMom);

        System.out.println(ded1);
        System.out.println(baba1);
        System.out.println(ded2);
        System.out.println(baba2);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);



    }

    public static class Human
    {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;

        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
