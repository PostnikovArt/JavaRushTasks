package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        //напишите тут ваш код
        int[] ints = getInts();
        for (int i = 0; i < ints.length; i++) {
            int buffer = ints[i];
            if (buffer > maximum) maximum = buffer;
            if (buffer < minimum) minimum = buffer;
        }

        System.out.print(maximum + " " + minimum);
    }

    //напишите тут ваш код
    public static int[] getInts() throws IOException {
        int[] a = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            int buffer = Integer.parseInt(reader.readLine());
            a[i] = buffer;
        }

        return a;
    }
}
