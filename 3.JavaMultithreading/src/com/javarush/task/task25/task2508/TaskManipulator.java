package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;


    @Override
    public void start(String threadName) {

        thread = new Thread(this, threadName);

        thread.start();
        //System.out.println(thread.getName() + " ---- Started");
    }

    @Override
    public void stop() {
        thread.interrupt();
        //System.out.println(thread.getName() + " ---- Stopped");

    }

    @Override
    public void run() {

        while ( ! thread.isInterrupted()) {
            System.out.println(this.thread.getName());
//            if (thread.isInterrupted()) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    //e.printStackTrace();
//                    break;
//                }
//            }
            try {
                thread.sleep(100);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                break;
            }
        }
    }
}
