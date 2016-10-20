package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try {
            float i = 1 / 0;
        } catch (Exception e){
            exceptions.add(e);
        }
        //Add your code here
        try {
            FileReader reader = new FileReader("eg");
        }catch (FileNotFoundException e){
            exceptions.add(e);
        }
        try {
            int a = 2/0;
        }catch (ArithmeticException e){
            exceptions.add(e);
        }
        try {
            int[] arrays = new int[2];
            arrays[3] = 2;
        }catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        try{
            throw new IllegalStateException();
        }catch (IllegalStateException e){
            exceptions.add(e);
        }
        try{
            throw new NoSuchElementException();
        }catch (NoSuchElementException e){
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        }catch (ClassNotFoundException e){
            exceptions.add(e);
        }
        try {
            throw new NoSuchMethodException();
        }catch (NoSuchMethodException e){
            exceptions.add(e);
        }
        try {
            throw new NullPointerException();
        }catch (NullPointerException e){
            exceptions.add(e);
        }
        try {
            throw new RuntimeException();
        }catch (RuntimeException e){
            exceptions.add(e);
        }

    }
}
