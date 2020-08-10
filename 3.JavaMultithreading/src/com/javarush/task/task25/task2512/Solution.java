package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (t != null) {
            t.interrupt();
        }
        List<Throwable> throwables = new ArrayList<>();
        while (e != null) {
            throwables.add(e);
            e = e.getCause();
        }
        Collections.reverse(throwables);
        for (Throwable throwable : throwables) {
            System.out.println(throwable.getClass().getName() + ": " + throwable.getMessage());
        }

    }

    public static void main(String[] args) {
    }
}
