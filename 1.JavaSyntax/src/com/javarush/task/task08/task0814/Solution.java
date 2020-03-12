package com.javarush.task.task08.task0814;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> setNumbers = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            setNumbers.add(i);
        }
        return setNumbers;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        HashSet<Integer> integers = new HashSet<>(set);
        for (Integer integer : integers) {
            if (integer > 10) {
                set.remove(integer);
            }
        }
//        set.removeIf(integer -> integer > 10);  вот как надо !!!!!!!!!!!!!!!!!!!!!!!!
//                return set;
        return set;
    }

    public static void main(String[] args) {

//        Set<Integer> probe = removeAllNumbersGreaterThan10(createSet());
//        for (Integer integer : probe) {
//            System.out.println(integer);
//        }

    }
}
