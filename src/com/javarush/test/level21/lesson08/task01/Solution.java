package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution o = (Solution) super.clone();
        Map<String, User> forClone = new LinkedHashMap<String, User>();
        for (Map.Entry<String, User> entry : users.entrySet()){
            String key = entry.getKey();
            User value = entry.getValue();
            forClone.put(key, (User)value.clone());
        }
        o.users = forClone;
        return o;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            User o = null;
            try{
                o = (User) super.clone();
            } catch (CloneNotSupportedException e){
            }
            return o;
        }
    }
}
