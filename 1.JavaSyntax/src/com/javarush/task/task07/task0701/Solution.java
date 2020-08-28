package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int[] ints = new int[20];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            int buffer = Integer.parseInt(bufferedReader.readLine());
            ints[i] = buffer;
        }
        return ints;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (max < i)
                max = i;
        }
        return max;
    }
}
