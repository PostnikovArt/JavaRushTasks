package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        StringBuilder words = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] buffer = reader.readLine().split(" ");
                for (String s : buffer) {
                    if (s.length() > 6) {
                        words.append(s + ",");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        words = words.deleteCharAt(words.length() -1);

        try (FileWriter writer = new FileWriter(args[1])) {
            writer.write(words.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
