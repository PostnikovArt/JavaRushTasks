package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {

        String fileName = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            //fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("/home/artic/IdeaProjects/Tests/test1"))) {
//        try  BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {

//                String result = reader.readLine();
//                for (Map.Entry<Integer, String> entry : map.entrySet()) {
//                    result = result.replaceAll(entry.getKey().toString(), entry.getValue());
//                }

                String[] buffer = reader.readLine().split(" ");

                for (int i = 0; i < buffer.length; i++) {

                    if ( buffer[i].matches(" ")) {
                        for (Map.Entry<Integer, String> entry : map.entrySet()) {
                            if (Integer.parseInt(buffer[i]) == entry.getKey()) {
                                buffer[i] = entry.getValue();
                            }
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                for (String s : buffer) {
                    result.append(s + " ");
                }

                System.out.println(result.toString().trim());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
