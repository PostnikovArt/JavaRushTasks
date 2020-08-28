package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        int count = 0;
        BufferedReader reader;

        reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String buffer = reader.readLine();
            String[] words = buffer.split("\\W");
            for (String word : words) {
                if (word.equals("world")) count++;
            }
        }
        reader.close();
        System.out.println(count);
    }
}
