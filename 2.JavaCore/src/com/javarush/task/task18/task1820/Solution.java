package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName1 = null;
        String fileName2 = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //fileName1 = "/home/artic/IdeaProjects/Tests/test1";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
             FileWriter writer = new FileWriter(fileName2)) {
            while (reader.ready()) {
                String[] buffer = reader.readLine().split(" ");
                for (String s : buffer) {
                    double i = Double.parseDouble(s);
                    int a = (int) Math.round(i);
                    writer.write(a + " ");
                    //System.out.println(a);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
