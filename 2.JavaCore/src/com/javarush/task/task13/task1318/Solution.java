package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        String fileNae = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileNae = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(fileNae)) {
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileNae));
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}