package com.javarush.task.task04.task0424;

/* 
Три числа
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

        if (a == b && b == c) return;
        if (a != b && b != c && c != a) {

        }
        else {

            if (a != b && a != c) {
                System.out.println("1");
                return;
            }
            if (b != a && b != c) {
                System.out.println("2");
                return;
            }
            if (c != b && c != a) {
                System.out.println("3");
                return;
            }
        }


//        if(a==b) System.out.println(3);
//        else if(b==c) System.out.println(1);
//        else if(a==c) System.out.println(2);
    }
}
