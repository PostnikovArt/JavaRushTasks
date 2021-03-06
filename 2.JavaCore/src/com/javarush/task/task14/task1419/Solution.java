package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        exceptions.add(new NullPointerException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new Exception());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new DataFormatException());
        exceptions.add(new ClassCastException());
        exceptions.add(new SecurityException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new ArrayIndexOutOfBoundsException());

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NumberFormatException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }
//        try {
//            throw new NullPointerException();
//        } catch (Exception e) {
//            exceptions.add(e);
//        }

    }
}
