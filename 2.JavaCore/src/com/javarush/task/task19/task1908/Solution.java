package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        try {
            BufferedReader bufferedReader  = new BufferedReader(new FileReader(fileName1));
            while (bufferedReader.ready()) {
                answer += bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedWriter fileWriter;

        try {
            fileWriter = new BufferedWriter(new FileWriter(fileName2));
            String[] allWords = answer.split(" ");
            for (String word : allWords) {
                if (word.matches("\\d+")) {
                    fileWriter.write(word + " ");

                }
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
