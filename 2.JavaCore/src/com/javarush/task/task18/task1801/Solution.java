package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        byte max = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            byte buffer = (byte)inputStream.read();
            if (buffer > max) {
                max = buffer;
            }
        }
        inputStream.close();
        System.out.println(max);
    }
}
