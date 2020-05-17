package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        while (true) {
            try {
               fileName  = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try(FileInputStream fileReader = new FileInputStream(fileName)) {



            if (fileReader.available() < 1000) {
                throw new DownloadException();
            }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public static class DownloadException extends Exception {

    }
}
