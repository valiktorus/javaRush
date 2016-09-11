package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        public String name;
        public boolean sex;
        public int age;
        public int height;
        public int mass;
        public String job;

        public Human(String name, boolean sex, int age, int height, int mass, String job){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.mass = mass;
            this.job = job;
        }
        public Human(String name, boolean sex, int age, int height, int mass) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.mass = mass;
        }
        public Human(String name, boolean sex, int age, int height){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.height = height;

        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }
        public Human(String name){
            this.name = name;
        }
        public Human(String name, int age, int height, int mass, String job){
            this.name = name;
            this.age = age;
            this.height = height;
            this.mass = mass;
            this.job = job;
        }
        public Human(String name, boolean sex, int height, int mass, String job){
            this.name = name;
            this.sex = sex;
            this.height = height;
            this.mass = mass;
            this.job = job;
        }
        public Human(String name, int mass, String job){
            this.name = name;
            this.mass = mass;
            this.job = job;
        }
        public Human(String name, String job){
            this.name = name;
            this.job = job;
        }


    }

}
