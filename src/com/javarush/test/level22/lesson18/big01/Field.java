package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Torus on 10.01.2017.
 */
public class Field {
    public int width;
    public int height;
    public int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public void print(){

    }
    public void removeFullLines(){

    }
    public Integer getValue(int x, int y){
        return 0;
    }
    public void setValue(int x, int y, int value){

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
