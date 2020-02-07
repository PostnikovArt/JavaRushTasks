package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int answer = 1;
        for (int i = 1; i < 11; i++) {
            int buffer = answer*i;
            answer = buffer;
        }

        System.out.println(answer);
    }
}
