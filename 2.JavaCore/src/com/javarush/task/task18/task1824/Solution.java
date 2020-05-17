package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;

        try {
            while (true) {
                String fileName = reader.readLine();
                if (fileName.isEmpty()) break;
                try {
                    inputStream = new FileInputStream(fileName);
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(fileName);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
