package com.javarush.task.task16.task1633;

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        Thread.setDefaultUncaughtExceptionHandler(handler);
//        threadA.setUncaughtExceptionHandler(handler);    //сработало и так
//        threadB.setUncaughtExceptionHandler(handler);

        /* 1.  "Определить свой класс ThreadGroup и переопределить метод uncaughtException()." - это нельзя
         т.к. наши нити просто нити по условиям задачи.

           2. Вызвать статический метод класса Thread — setDefaultUncaughtExceptionHandler().
         Это можно. Если вызовем и туда пихнём наш хэндлер, то все нити будут именно им пользоваться.
         В реальном проекте нафиг-нафиг. Но знать полезно.

           3. Вызвать метод setUncaughtExceptionHandler() у ___объекта___
         (а не как тут ниже в комментах просто класса) класса Thread. Вот, то что нужно.
          Берем наши нитки, и каждой через эту функцию посылаем приветик,
          в виде handler, чтобы она знала как обрабатывать такие эксцепшены.

           4. Замечательно всё работает через конструктор TestedThread,
          если в нем установим обработчиком "по дефолту" - наш обработчик:
          public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setDefaultUncaughtExceptionHandler(handler);  }   */

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
