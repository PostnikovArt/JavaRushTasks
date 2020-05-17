package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        String file_Name = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file_Name = bufferedReader.readLine();
        }

        Byte minValue = Byte.MAX_VALUE;
        try (FileInputStream fileInputStream = new FileInputStream(file_Name)) {
            while (fileInputStream.available() > 0) {
                byte buffer = (byte) fileInputStream.read();
                if (minValue > buffer) minValue = buffer;
            }
        }


        System.out.println(minValue);
    }
}
