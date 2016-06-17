package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String name = null;
    private int weight = 5;
    private int age = 4;
    private String adress = null;
    private String color = null;

    public Cat(String name){
        this.name = name;
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight =weight;
        this.age = age;
    }
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Cat(int age, String color){
        this.age = age;
        this.color = color;
    }
    public Cat(int age, String color, String adress){
        this.age = age;
        this.color = color;
        this.adress = adress;
    }

}
