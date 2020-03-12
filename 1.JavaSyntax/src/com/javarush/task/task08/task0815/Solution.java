package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> people = new HashMap<>(10);
        people.put("Pupkin", "Vova");
        people.put("Pupkin2", "Vova");
        people.put("Pupkin3", "Vova");
        people.put("Pupkin4", "Vova4");
        people.put("Pupkin5", "Vova5");
        people.put("Pupkin6", "Vova6");
        people.put("Pupkin7", "Vova7");
        people.put("Pupkin8", "Vova8");
        people.put("Pupkin9", "Vova9");
        people.put("Pupkin0", "Vova0");

        return people;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;

        for (String value : map.values()) {
            if (name.equals(value)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;

        for (String s : map.keySet()) {
            if (s.equals(lastName)) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {

//        System.out.println(getCountTheSameFirstName(createMap(), "Vova"));
//        System.out.println(getCountTheSameLastName(createMap(), "Pupkin"));
    }
}
