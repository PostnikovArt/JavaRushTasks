package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            while (reader.ready()) {
                text.append(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = text.toString().replaceAll("\\pP", "");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
