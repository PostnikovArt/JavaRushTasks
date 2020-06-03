package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[] allBytes = new int[256];
        Arrays.fill(allBytes, 0);
//        String fileName = "/home/artic/Tests/testText1";
        String fileName = args[0];

        try (FileInputStream inputStream = new FileInputStream(fileName)) {

            while (inputStream.available() > 0) {
                int buffer = inputStream.read();
                //int count = allBytes[buffer];
                allBytes[buffer] += 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < allBytes.length; i++) {
            if (allBytes[i] > 0) System.out.println((char)i + " " + allBytes[i]);
        }
    }
}
