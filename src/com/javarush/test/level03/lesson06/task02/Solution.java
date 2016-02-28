package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution {


    public static void main(String[] args)
    {
        double[][] divide = new double[10][10];
        for (int i = 0; i <10 ; i++){
            for (int j = 0; j <10 ; j++){
                if(i == 0){
                    divide[i][j] = (double) j;
                    System.out.print(String.format("%2.2f\t", divide[i][j]));
                }else{
                    if (j != 0)
                    {
                        divide[i][j] = (double) i / j;
                        System.out.print(String.format("%2.2f\t", divide[i][j]));
                    } else
                    {
                        divide[i][j] = 0.0;

                    }
                }
            }
            System.out.println("");


        }
    }

   /* public static void main(String[] args)
    {
        double[][] multi = new double[11][11];
        for (int i = 0; i < 11; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                if (i == 0 && j == 0)
                {
                    System.out.print("0.0" + "\t\t");
                } else
                {
                    if (i == 10.0 & j == 0.0)
                    {
                        multi[i][j] = (i) / (j + 1);
                        System.out.print(multi[i][j] + "\t");
                    } else
                    {
                        multi[i][j] = (i) / (j + 1);
                        System.out.print(multi[i][j] + "\t\t");
                    }
                }
            }
            System.out.println();

        }
    }*/




/*
    public static void main(String[] args) {
        // создаем двумерный массив 10 на 10
        int[][] multiplyTab  = new int[10][10];

        // цикл по первой размерности
        for (int i = 0; i < 10; i++) {
            // цикл по второй размерности
            for (int j = 0; j < 10; j++) {
                //инициализация элементов массива
                multiplyTab[i][j] = (i+1)*(j+1);

                //вывод элементов массива
                System.out.print(multiplyTab[i][j] + "\t");
            }
            System.out.println();
        }
    }
    */
}
