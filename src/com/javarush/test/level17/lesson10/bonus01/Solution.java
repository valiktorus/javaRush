package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        if (args.length != 0) {
            if ((args[0].equals("-c")) && (args.length == 4)) {
                Create(args[0], args[1], args[2], args[3]);
            } else if ((args[0].equals("-u")) && (args.length == 5)) {
                Update(args[0], args[1], args[2], args[3], args[4]);
            } else if ((args[0].equals("-d")) && (args.length == 2)) {
                Delete(args[0], args[1]);
            } else if ((args[0].equals("-i")) && (args.length == 2)) {
                Inform(args[0], args[1]);
            }
        } else {
            System.out.println("Not argument");
        }
    }

    private static void Create(String arg, String arg1, String arg2, String arg3) throws ParseException {
        SimpleDateFormat datB = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dat = datB.parse(arg3);
        if (arg2.equals("м")) allPeople.add(Person.createMale(arg1, dat));
        if (arg2.equals("ж")) allPeople.add(Person.createFemale(arg1, dat));
        System.out.println(allPeople.size() - 1);
    }

    private static void Update(String arg, String arg1, String arg2, String arg3, String arg4) throws ParseException {
        SimpleDateFormat datB = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dat = datB.parse(arg4);
        int id = Integer.parseInt(arg1);
        allPeople.get(id).setName(arg2);
        if (arg3.equals("м")) allPeople.get(id).setSex(Sex.MALE);
        else if (arg3.equals("ж")) allPeople.get(id).setSex(Sex.FEMALE);
        allPeople.get(id).setBirthDay(dat);
    }

    private static void Delete(String arg, String arg1) {
        int id = Integer.parseInt(arg1);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    private static void Inform(String arg, String arg1) {
        String Pol = "not sex";
        if (allPeople.get(Integer.parseInt(arg1)).getSex().equals(Sex.MALE)) {
            Pol = "м";
        } else if (allPeople.get(Integer.parseInt(arg1)).getSex().equals(Sex.FEMALE)) {
            Pol = "ж";
        }
        int id = Integer.parseInt(arg1);
        String name = allPeople.get(Integer.parseInt(arg1)).getName();
        SimpleDateFormat tmpDat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dat = tmpDat.format(allPeople.get(id).getBirthDay());
        System.out.println(name + " " + Pol + " " + dat);
    }
}
