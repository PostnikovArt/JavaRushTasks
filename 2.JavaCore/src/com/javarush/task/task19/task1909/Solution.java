package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String fileName1 = "";
        String fileName2 = "";
        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new FileReader(fileName1));
            writer = new BufferedWriter(new FileWriter(fileName2));
            while (reader.ready()) {
                String buffer = reader.readLine();
                String text = buffer.replace(".", "!");
                writer.write(text);
            }
            reader.close();
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
