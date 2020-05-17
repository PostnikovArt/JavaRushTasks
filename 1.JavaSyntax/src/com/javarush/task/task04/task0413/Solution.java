package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 0 && n < 8) {
            switch (n) {
                case 1 :
                    System.out.println("понедельник");
                    break;
            }
            switch (n) {
                case 2 :
                    System.out.println("вторник");
                    break;
            }
            switch (n) {
                case 3 :
                    System.out.println("среда");
                    break;
            }
            switch (n) {
                case 4 :
                    System.out.println("четверг");
                    break;
            }
            switch (n) {
                case 5 :
                    System.out.println("пятница");
                    break;
            }
            switch (n) {
                case 6 :
                    System.out.println("суббота");
                    break;
            }
            switch (n) {
                case 7 :
                    System.out.println("воскресенье");
                    break;
            }

        }
        else System.out.println("такого дня недели не существует");

    }
}