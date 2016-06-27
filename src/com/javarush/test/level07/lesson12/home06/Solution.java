package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandfather1 = new Human("Petia",true,78,null,null);
        Human grandmother1 = new Human("Masha", false,76,null,null);

        Human grandfather2 = new Human("Vasia", true, 77, null,null);
        Human grandmother2 = new Human("vasilisa", false, 75, null,null);

        Human father = new Human("Misha", true,48, grandfather1, grandmother1);
        Human mother = new Human("Katia", false, 46, grandfather2,grandmother2);

        Human son1 = new Human("Anatolii", true,20,father,mother);
        Human son2 = new Human("Andrei", true,16,father,mother);
        Human son3 = new Human("Kolia", true,18,father,mother);

        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);

        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father = null;
        private Human mother = null;



        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex =sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
