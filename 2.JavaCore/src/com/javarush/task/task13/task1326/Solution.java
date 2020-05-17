package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
//        String fileName = "/home/artic/Tests/test3";
        String fileName = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder builder = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int b = inputStream.read();
                builder.append((char)b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings = builder.toString().split("\\s");

        ArrayList<Integer> result = new ArrayList<>();
        for (String current : strings) {
            if (!current.isEmpty()) {
                int i = Integer.parseInt(current);
                if (i%2 == 0) result.add(i);
            }
        }
        Collections.sort(result);

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
