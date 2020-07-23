package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел Ӏ Java Syntax: 4 уровень, 6 лекция
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
        if (a >= b) {
            System.out.println(b);
        }
        else System.out.println(a);
    }
}