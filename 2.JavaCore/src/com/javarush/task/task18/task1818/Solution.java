package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
//            String fileName1 = "/home/artic/Tests/testText1";
//            String fileName2 = "/home/artic/Tests/testText2";
//            String fileName3 = "/home/artic/Tests/testText3";
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
            FileInputStream inputStream = new FileInputStream(fileName2);
            byte[] buffer = new byte[1024];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                fileOutputStream.write(buffer, 0 , count);
            }
            inputStream.close();
            inputStream = new FileInputStream(fileName3);
            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                fileOutputStream.write(buffer, 0 , count);
            }
            inputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
