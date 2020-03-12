package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            strings.add("1");
        }
        System.out.println(strings.size());
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
