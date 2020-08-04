package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

        HashMap<String, Double> map = new HashMap<>();

//        try (BufferedReader reader = new BufferedReader(new FileReader("/home/artic/IdeaProjects/Tests/test1"))) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] buffer = reader.readLine().split(" ");
                if (map.containsKey(buffer[0])) {
                    map.put(buffer[0], (map.get(buffer[0]) + Double.parseDouble(buffer[1])));
                } else {
                    map.put(buffer[0], Double.parseDouble(buffer[1]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> names = new ArrayList<>();
        for (String s : map.keySet()) {
            names.add(s);
        }
        Collections.sort(names);

        for (String name : names) {
            System.out.println(name + " " + map.get(name));
        }
    }
}
