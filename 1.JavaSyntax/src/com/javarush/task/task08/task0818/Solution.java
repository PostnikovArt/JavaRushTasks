package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("vova" + i, 495 + i);
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Set<String> delSet = new HashSet<>();
        for (Map.Entry<String, Integer> s : map.entrySet()) {
            if (s.getValue() < 500) {
                delSet.add(s.getKey());
            }
        }
        map.keySet().removeAll(delSet);
    }

    public static void main(String[] args) {

//        Map<String, Integer> map = createMap();
//        removeItemFromMap(map);
//        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//            System.out.println(stringIntegerEntry.getKey() + "  " + stringIntegerEntry.getValue());
//        }
    }
}