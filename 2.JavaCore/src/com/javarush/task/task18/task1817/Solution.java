package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int[] allSymbols = new int[256];
        Arrays.fill(allSymbols, 0);

        String fileName = args[0];

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) {
                int buffer = inputStream.read();
                allSymbols[buffer] += 1;
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int allCount = 0;
        for (int symbol : allSymbols) {
            if (symbol != 0) allCount += symbol;
        }
        int spaceCount = allSymbols[32];

//        float result = spaceCount/allCount*100;

//        System.out.println(String.format("%.2f", (float)s/all*100.0));
        System.out.println(String.format("%.2f", (float)spaceCount/allCount*100));

    }
}
