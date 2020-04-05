package com.javarush.task.task14.task1421;

public final class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        if (instance.equals(null)) {
            this.instance = new Singleton();
        }
    }

    public static Singleton getInstance() {
        if (instance.equals(null)) {
            new Singleton();
        }
        return instance;
    }
}
