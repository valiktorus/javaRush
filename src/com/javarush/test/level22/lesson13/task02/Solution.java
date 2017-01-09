package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String firstFileName = args[0];
        String secondFileName = args[1];
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(firstFileName));
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(secondFileName));
        String line;
        Charset inputChar = Charset.forName("UTF-8");
        Charset outputChar = Charset.forName("Windows-1251");
        byte[] buffer = new byte[reader.available()];
        while(reader.available() > 0){
            int i = reader.read(buffer);
            String s = new String(buffer,0,i,inputChar);
            buffer = s.getBytes(outputChar);
            writer.write(buffer);
        }
        reader.close();
        writer.close();
    }
}
