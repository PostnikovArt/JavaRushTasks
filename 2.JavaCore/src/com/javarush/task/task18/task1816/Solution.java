package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try {
            FileInputStream inputStream  = new FileInputStream(args[0]);
            while (inputStream.available() > 0) {
                int buffer = inputStream.read();
                if (65 <= buffer && buffer <= 90) count++;
                if (97 <= buffer && buffer <= 122) count++;
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
