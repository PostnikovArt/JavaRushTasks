package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                while (reader.ready()) {
                String[] buffer = reader.readLine().split(" ");
                if (map.containsKey(buffer[0])) {
                    map.replace(buffer[0], map.get(buffer[0]),
                            (map.get(buffer[0]) + Double.parseDouble(buffer[1])));
                } else {
                    map.put(buffer[0], Double.parseDouble(buffer[1]));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (BufferedReader reader = new BufferedReader(new FileReader("/home/artic/Tests/test3"))) {
//            String[] buffer = reader.readLine().split(" ");
//            if (map.containsKey(buffer[0])) {
//                map.replace(buffer[0], map.get(buffer[0]),
//                        map.get(buffer[0]) + Double.parseDouble(buffer[1]));
//            }else map.put(buffer[0], Double.parseDouble(buffer[1]));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Double max = Double.MIN_VALUE;
        for (Double value : map.values()) {
            if (max < value) max = value;
        }
//        ArrayList<String> namesMax = new ArrayList<>();
//
//        for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
//            if (stringDoubleEntry.getValue().equals(max)) namesMax.add(stringDoubleEntry.getKey());
//        }
//
//        Collections.sort(namesMax);
//
//        for (String s : namesMax) {
//            System.out.println(s);
//        }
        Map<String, Double> result = new TreeMap<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue().equals(max)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, Double> entry : result.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}
