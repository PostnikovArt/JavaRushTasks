package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        String fileName = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            while ( ! (fileName = bufferedReader.readLine()).equals("exit")) {
                Thread thread = new ReadThread(fileName);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        int[] chars = new int[256];

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            super.run();
            Arrays.fill(chars, 0);
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName))) {
                while (inputStream.available() > 0) {
                    int i = inputStream.read();
                    chars[i]++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < chars.length; i++) {
                if (max < chars[i]) max = chars[i];
            }

            for (int i = 0; i < chars.length; i++) {
                synchronized (resultMap) {
                    if (chars[i] == max) {
                        resultMap.put(fileName, i);
                    }
                }
            }

        }


    }
}
