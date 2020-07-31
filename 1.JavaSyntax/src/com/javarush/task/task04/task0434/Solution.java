package com.javarush.task.task04.task0434;

/* 
Таблица умножения Ӏ Java Syntax: 4 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        int buffer = 1;
        int count = 1;
        while (count < 11) {
            System.out.print(buffer * count);
            System.out.print(" ");
            buffer++;
            if (buffer == 11) {
                System.out.println();
                count++;
                buffer = 1;
            }
        }
    }
}
