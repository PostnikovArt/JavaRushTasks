package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

//        Integer[] array = new Integer[] {13, 8, 15, 5, 17,11};
//
//        sort(array);
//        for (Integer integer : array) {
//            System.out.println(integer);
//        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);

        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(array);


        Integer median;
        if (array.length%2 == 0) {
            Integer median1 = array[array.length/2 -1];
            Integer median2 = array[array.length/2];

            median = (median1 + median2)/2;

        } else {
            median = array[(array.length - 1)/2];
//            System.out.println(" gggggggg" + median);

        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return (Math.abs(median-o1) - Math.abs(median-o2));
            }
        };
        Collections.sort(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }



//        Integer median;
//        Integer median2;
//        if (array.length%2 == 0) {
//            median = array.length/2 -1;
//            median2 = array.length/2;
//            list.add(array[median]);
//            list.add(array[median2]);
//            System.out.println("med1 - " + median);
//            System.out.println("med2 - " + median2);

//        } else {
//            median = (array.length - 1)/2;
//            median2 = median;
//            list.add(array[median]);
//            System.out.println("med1 - " + median);
//            System.out.println("med2 - " + median2);
//        }
//
//        for (Integer i = median -1, k = median2 +1; i >= 0 && k < array.length ; ) {
//            if (array[median].compareTo(array[i]) <= array[k].compareTo(array[median2])) {
//                System.out.println("median.compareTo(i) -- " + i + " " + array[i]);
//                System.out.println("k.compareTo(median2) -- " + k + " " + array[k]) ;
//                System.out.println(median.compareTo(array[i]) + " " + array[k].compareTo(median2));
//                list.add(array[i--]);
//            } else {
//                list.add(array[k++]);
//            }
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
        return array;
    }
}
