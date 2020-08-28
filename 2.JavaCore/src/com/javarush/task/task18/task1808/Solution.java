package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String firstFile = null;
        String secondFile = null;
        String thirdFile = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFile = reader.readLine();
            secondFile = reader.readLine();
            thirdFile = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder allWords = new StringBuilder();
        try (FileInputStream fileReader = new FileInputStream(firstFile)){
            while (fileReader.available() > 0 ) {
                allWords.append((char)fileReader.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (allWords.length()%2 == 0) {
            try (FileOutputStream secondFileWriter = new FileOutputStream(secondFile);
                 FileOutputStream thirdFileWriter = new FileOutputStream(thirdFile)) {
                String firstHalf = allWords.substring(0, allWords.length()/2);
                String secondHalf = allWords.substring(allWords.length()/2);
                secondFileWriter.write(firstHalf.getBytes());
                thirdFileWriter.write(secondHalf.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try (FileOutputStream secondFileWriter = new FileOutputStream(secondFile);
                 FileOutputStream thirdFileWriter = new FileOutputStream(thirdFile)) {
                String firstHalf = allWords.substring(0, allWords.length()/2 +1);
                String secondHalf = allWords.substring(allWords.length()/2 +1);
                secondFileWriter.write(firstHalf.getBytes());
                thirdFileWriter.write(secondHalf.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        StringBuilder allWords = new StringBuilder();
//        allWords = allWords.append("aabbc");
//        String firstHalf = allWords.substring(0, allWords.length()/2);
//        String secondHalf = allWords.substring(allWords.length()/2);
//        System.out.println(firstHalf);
//        System.out.println(secondHalf);
    }
}
