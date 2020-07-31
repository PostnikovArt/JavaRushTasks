package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        int count = 10;
        while (count > 0) {
            int buffer = 10;
            while (buffer > 0) {
                System.out.print("S");
                buffer--;
            }
            System.out.println();
            count--;
        }
    }
}
