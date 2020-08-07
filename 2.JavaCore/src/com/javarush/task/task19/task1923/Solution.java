package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
//            try (BufferedReader reader = new BufferedReader(new FileReader("/home/artic/IdeaProjects/Tests/test1"));
//                 BufferedWriter writer = new BufferedWriter(new FileWriter("/home/artic/IdeaProjects/Tests/test2"))) {
                while (reader.ready()) {
                    String[] strings = reader.readLine().split(" ");
                    for (String s : strings) {
                        System.out.println(s);
                        if (s.matches(".*\\d+.*")) {
                            System.out.println(" ------ " + s);
                            writer.write(s + " ");
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

