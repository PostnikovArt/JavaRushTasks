package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        LinkedList<Byte> allBytes = new LinkedList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            byte buffer = (byte) inputStream.read();
            if (!allBytes.contains(buffer)) {
                allBytes.add(buffer);
            }
        }
        inputStream.close();

        Collections.sort(allBytes);
        for (Byte allByte : allBytes) {
            System.out.print(allByte + " ");
        }
    }
}
