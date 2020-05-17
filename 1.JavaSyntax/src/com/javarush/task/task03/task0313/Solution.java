package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        String[] strings = new String[] {"Мама","Мыла", "Раму"};
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                for (int k = 0; k < strings.length; k++) {
                    if (k != j && j != i && i != k) {
                        String buffer = strings[k] + strings[j] + strings[i];
                        if (!list.contains(buffer)) list.add(buffer);
                    }
                }

            }
        }

        for (String s : list) {
            System.out.println(s);
        }

    }
}
