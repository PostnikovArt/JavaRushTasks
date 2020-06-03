package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "Ivanov");
//        map.put("country", "Ukraine");
//        map.put("city", "Kiev");
//        map.put("age", null);
//        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {

        if (params.isEmpty()) return "";

        String[] strings = new String[(params.size())];
        int count = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if ((entry.getKey() != null) && (entry.getValue() != null)) {
                strings[count] = entry.getKey() + " = '" + entry.getValue() + "'";
            }
            else strings[count] = "";
            count++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if ((strings[i] != null) && ( ! strings[i].isEmpty()) ) {
                stringBuilder.append( " and " + strings[i]);
            }
        }

        return stringBuilder.toString();
    }
}
