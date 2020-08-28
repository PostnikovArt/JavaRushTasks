package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] intsBig = new int[20];
        int[] ints1 = new int[10];
        int[] ints2 = new int[10];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < intsBig.length; i++) {
            intsBig[i] = Integer.parseInt(bufferedReader.readLine());
        }

        bufferedReader.close();

        for (int i = 0; i < intsBig.length; i++) {
            if (i < intsBig.length/2) {
                ints1[i] = intsBig[i];
            }
            else ints2[i - intsBig.length/2] = intsBig[i];
        }

        for (int i : ints2) {
            System.out.println(i);
        }
    }
}
