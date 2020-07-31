package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        super.run();
        Thread.State state1 = thread.getState();
        System.out.println(state1);

        while (true) {
            Thread.State state2 = thread.getState();

            if ( ! state1.equals(state2)) {
                System.out.println(thread.getState());
                state1 = state2;
            }
            if (state1.equals(State.TERMINATED)) {
                return;
            }

            if (thread.getState().equals(State.TERMINATED)) {
                this.interrupt();
            }
        }
    }
}
