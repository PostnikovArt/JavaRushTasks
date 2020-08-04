package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        if (args.length <= 0) return;

        String fileName = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int ID = Integer.parseInt(args[0]);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String data = reader.readLine();
                String[] params = data.split(" ");
                int id = Integer.parseInt(params[0]);
                if (ID == id) {
                    System.out.println(data);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
