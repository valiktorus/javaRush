package com.javarush.test.level14.lesson06.home01;

/**
 * Created by valiktorus on 19.10.2016.
 */
public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }
    @Override
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
