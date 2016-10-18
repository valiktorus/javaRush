package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        while (true){
            String buffer = reader.readLine();
            if (buffer.equals("exit")){
                list.add("exit");
                break;
            }else{
                list.add(buffer + "\n");
            }
        }
        reader.close();

        for (int i = 0; i <list.size() ; i++) {
            fileWriter.write(list.get(i));
        }
        fileWriter.close();
    }
}
