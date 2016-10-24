package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Torus on 24.10.2016.
 */
public class Earth implements Planet {
    private Earth(){}
    private static Earth instance;
    public static Earth getInstance(){
        if (instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
