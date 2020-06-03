package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file_Name = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (bufferedReader.ready()) {
                file_Name = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file_Name))) {
            while (reader.ready()) {
                StringBuilder buffer = new StringBuilder(reader.readLine());
                System.out.println(buffer.reverse());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
