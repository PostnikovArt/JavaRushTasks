package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top;
    int left;
    int width;
    int height;

    public void initialize() {

    }
    public void initialize(int top) {
        this.top = top;

    }
    public void initialize(int top, int left) {
        this.top = top;
        this.left = left;
    }
    public void initialize(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
    }

    public static void main(String[] args) {

    }
}
