package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        ArrayList<String> allNumbers = new ArrayList<>();

        BufferedReader nameFileReader = null;
        String nameFile = null;
        try {
            nameFileReader = new BufferedReader(new InputStreamReader(System.in));
            nameFile = nameFileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            nameFileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream = null;
        BufferedReader fileReader = null;
        try {
            fileInputStream = new FileInputStream(nameFile);
            while (fileInputStream.available() != -1) {
                fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String buffer = fileReader.readLine();
                System.out.println(buffer);
                allNumbers.add(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String numbers : allNumbers) {
            System.out.println(" 1 " + numbers);
            char[] charsNumbers = numbers.toCharArray();
            System.out.println(" 2 " + charsNumbers);
            for (char number : charsNumbers) {
                int i = number;
                if (i%2 == 0) {
                    System.out.println(i);
                }
            }
        }

        //     /home/artic/Tests/properties2
//
//        BufferedReader fileReader = null;
//        try {
//            fileReader = new BufferedReader(new FileReader(nameFile));
//            String buffer = fileReader.readLine();
//            allNumbers.add(buffer);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            fileReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}
