package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> names = new ArrayList<>(map.values());
        for (int i = 0; i < names.size() - 1; i++) {
            for (int j = i +1; j < names.size(); j++) {
                if (names.get(i).equals(names.get(j))) {
                    removeItemFromMapByValue(map, names.get(i));
                }
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

//        Map<String, String> stringMap = createMap();
//        removeTheFirstNameDuplicates(stringMap);
//        for (String value : stringMap.values()) {
//            System.out.println(value);
//        }
    }
}
