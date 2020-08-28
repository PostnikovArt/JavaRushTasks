package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String fileNae = "";
        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileNae = reader.readLine();
            writer = new BufferedWriter(new FileWriter(fileNae));
            String buffer;
            //writer.write(buffer);
            //writer.newLine();

            do {
                buffer = reader.readLine();
                writer.write(buffer);
                writer.newLine();
            } while (!buffer.equals("exit"));
            reader.close();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
