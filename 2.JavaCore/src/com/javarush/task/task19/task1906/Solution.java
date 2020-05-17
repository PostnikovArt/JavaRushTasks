package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String answer = "";
        String fileName1 = "";
        String fileName2 = "";


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fileReader;
        FileWriter fileWriter;

        try {
            fileReader = new FileReader(fileName1);
            fileWriter = new FileWriter(fileName2);

            while (fileReader.ready()) {
                fileReader.read();

                fileWriter.write(fileReader.read());

            }
            fileReader.close();
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
