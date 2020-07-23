package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
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
        if (a == b && a == c) {
            System.out.println(a + " " + b + " " + c);
            return;
        }

        int max = Math.max(Math.max(a, b), c);
//        int min = Math.min(Math.min(a, b), c);
//
//        System.out.println(max);
//        System.out.println(min);

        if (a == max) {
            System.out.println(a + " " + Math.max(b, c) + " " + Math.min(b, c));
            return;
        }
        if (b == max) {
            System.out.println(b + " " + Math.max(a, c) + " " + Math.min(a, c));
            return;
        }
        if (c == max) {
            System.out.println(c + " " + Math.max(b, a) + " " + Math.min(b, a));
        }

    }
}
