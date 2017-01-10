package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Torus on 10.01.2017.
 */
public class Figure {
    int x;
    int y;
    int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void left(){

    }
    public void right(){

    }
    public void up(){

    }
    public void down(){

    }
    public void downMaximum(){

    }
    public void rotate(){

    }
    public boolean isCurrentPositionAvailable(){
        return true;
    }
    public void landed(){

    }
}
