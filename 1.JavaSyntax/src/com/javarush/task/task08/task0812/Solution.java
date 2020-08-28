package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<Integer> integers = new ArrayList<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            integers.add( Integer.parseInt(bufferedReader.readLine()));
        }
        bufferedReader.close();

        int max = 1;
        int counter = 1;
        for (int i = 0; i < 9; i++) {

            if (integers.get(i).equals(integers.get(i +1))) {
                counter++;
                if (max < counter) {
                    max = counter;
                }
            }
            else counter = 1;
        }
        System.out.println(max);

    }
}