package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String[] buffer = string.split(" ");

                count = 0;
                for (String s : buffer) {
                    if (words.contains(s)) {
                        count++;
                    }
                }

                if (count == 2) {
                    System.out.println(string);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
