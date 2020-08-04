package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        Solution.cryptEncrypt(args);
    }

    public static void cryptEncrypt(String[] params) {

        int key = 5;

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        if (params[0].equals("-e")) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(params[1]));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(params[2]));
                int i;
                while ((i = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(i + key);
                }
                bufferedInputStream.close();
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (params[0].equals("-d")) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(params[1]));
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(params[2]));
                int i;
                while ((i = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(i - key);
                }
                bufferedInputStream.close();
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
