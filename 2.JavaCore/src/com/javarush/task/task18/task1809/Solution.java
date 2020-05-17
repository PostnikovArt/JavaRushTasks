package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader;
        FileInputStream inputStream;
        FileOutputStream outputStream;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String sourceFile = bufferedReader.readLine();
            String destinationFile = bufferedReader.readLine();
//            String sourceFile = "/home/artic/Tests/testText1";
//            String destinationFile = "/home/artic/Tests/testText2";
            bufferedReader.close();

            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationFile);

            if (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);

                byte[] reverseArray = new byte[buffer.length];
                for (int i = 0,j = buffer.length -1; i < buffer.length; i++, j--) {
                    reverseArray[j] = buffer[i];
                }


                outputStream.write(reverseArray, 0, count);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
