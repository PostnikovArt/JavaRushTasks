package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            int x = str.charAt(i);  вот как надо было, а конец цикла по str.length
            int buffer = Integer.parseInt(String.valueOf(chars[i]));
            if (buffer != 0) {
                if (buffer % 2 == 0) even++;
                else odd++;
            }
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
