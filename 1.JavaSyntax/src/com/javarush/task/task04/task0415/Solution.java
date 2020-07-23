package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();
        if (a >= (b + c)) {
            System.out.println("Треугольник не существует.");
            return;
        }
        if (b >= (a + c)) {
            System.out.println("Треугольник не существует.");
            return;
        }
        if (c >= (a + b)) {
            System.out.println("Треугольник не существует.");
            return;
        }
        System.out.println("Треугольник существует.");
    }
}