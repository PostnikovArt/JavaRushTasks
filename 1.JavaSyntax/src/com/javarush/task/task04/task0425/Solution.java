package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        reader.close();
        if (a > 0 && b > 0) {
            System.out.println("1");
            return;
        }
        if (a < 0 && b > 0) {
            System.out.println("2");
            return;
        }
        if (a < 0 && b < 0) {
            System.out.println("3");
            return;
        }
        if (a > 0 && b < 0) {
            System.out.println("4");
            return;
        }
    }
}
