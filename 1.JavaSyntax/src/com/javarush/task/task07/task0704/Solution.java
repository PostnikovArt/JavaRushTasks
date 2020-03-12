package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] ints = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            ints[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] ints1 = new int[10];
        for (int i = ints.length -1,j = 0; i >= 0; i--, j++) {
            ints1[j] = ints[i];
        }
        for (int i : ints1) {
            System.out.println(i);
        }

    }
}

