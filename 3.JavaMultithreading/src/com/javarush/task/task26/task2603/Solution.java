package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }


    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }


        @Override
        public int compare(T o1, T o2) {
            Comparator<T> nowCompare = comparators[0];
            for (Comparator<T> comparator : comparators) {
                int result = comparator.compare(o1,o2);
                if (result != 0) return result;
            }
//            for (int i = 1; i < comparators.length; i++) {
//                int result = comparators[i].compare(o1,o2);
//                if (result != 0) return result;
//            }
            return 0;
        }
    }


}