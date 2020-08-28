package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {

        Integer max = 1;
        HashMap<Integer, Integer> mapAllBytes = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            Integer key = inputStream.read();

            if (mapAllBytes.containsKey(key)) {
                mapAllBytes.put(key, mapAllBytes.get(key) +1);

                if (mapAllBytes.get(key) > max)   max = mapAllBytes.get(key);

            } else {
                mapAllBytes.put(key, 1);
            }
        }
        inputStream.close();

        for (Map.Entry<Integer, Integer> entry : mapAllBytes.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
