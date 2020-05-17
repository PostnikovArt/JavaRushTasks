package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        Solution cloneSolution = new Solution();
        Map<String, User> newUsers = new LinkedHashMap();
        for (Map.Entry<String, User> entry : this.users.entrySet()) {
            newUsers.put(entry.getKey(),entry.getValue());
        }
        cloneSolution.users = newUsers;
        return cloneSolution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
//            return super.clone();
            User user = new User(this.age,this.name);

            return user;
        }
    }
}
