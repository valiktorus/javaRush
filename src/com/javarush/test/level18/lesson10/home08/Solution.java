package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")){
            new ReadThread(fileName).start();
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        Map<Integer, Integer> map = new HashMap<>();

        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName =fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream reader = new FileInputStream(fileName);
                int readedByte;
                while (reader.available()>0) {
                    readedByte = reader.read();
                    if (map.containsKey(readedByte)) {
                        map.put(readedByte, map.get(readedByte) + 1);
                    } else {
                        map.put(readedByte, 1);
                    }
                }
                reader.close();
                int max = 0;
                int keyMax = 0;
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getValue() > max) {
                        max = pair.getValue();
                        keyMax = pair.getKey();
                    }
                }
                resultMap.put(fileName, keyMax);

            }catch (IOException e){
                e.getStackTrace();
            }
        }


    }
}
