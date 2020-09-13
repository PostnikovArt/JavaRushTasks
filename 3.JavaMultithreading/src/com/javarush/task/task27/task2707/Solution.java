package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }
//    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
//        synchronized (obj2) {
//            synchronized (obj1) {
//                System.out.println(obj1 + " " + obj2);
//            }
//        }
//    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
//                solution.someMethodWithSynchronizedBlocks(o2, o1);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        Thread.sleep(20);
        thread2.start();
        Thread.sleep(20);
        thread3.start();
        Thread.sleep(10);

        if (thread2.getState() == Thread.State.BLOCKED && thread3.getState() != Thread.State.BLOCKED) {
            thread2.interrupt();
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            count++;
            if(!isLockOrderNormal(solution, o1, o2)) {
                System.out.println(count);
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                break;
            }
        }
    }
}
