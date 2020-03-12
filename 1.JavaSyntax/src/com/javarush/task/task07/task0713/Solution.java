package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>(20);
        ArrayList<Integer> odd3 = new ArrayList<>(20);
        ArrayList<Integer> cher2 = new ArrayList<>(20);
        ArrayList<Integer> simples = new ArrayList<>(20);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            integers.add(Integer.parseInt(bufferedReader.readLine()));
        }
        bufferedReader.close();

        for (Integer integer : integers) {
            int counter = 0;
            if (integer%3 == 0) {
                odd3.add(integer);
                counter++;
            }
            if (integer%2 == 0) {
                cher2.add(integer);
                counter++;
            }

            if (counter == 0) simples.add(integer);
        }

        printList(odd3);
        printList(cher2);
        printList(simples);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
