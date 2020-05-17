package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> namesFiles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String buffer = null;
        while (true) {
            try {
                if (((buffer = reader.readLine()).equals("end"))) break;
                namesFiles.add(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(namesFiles);
        String nameOfCommonFile = namesFiles.get(0).substring(0, namesFiles.get(0).lastIndexOf('.'));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfCommonFile))) {
            for (String current : namesFiles) {
                reader = new BufferedReader(new FileReader(current));
                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.flush();
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
