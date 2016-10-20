package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by valiktorus on 20.10.2016.
 */
public class Singleton {
    private Singleton() {
    }
    private static Singleton instance = null;

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
