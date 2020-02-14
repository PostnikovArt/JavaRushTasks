package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age = 3;
    int weight = 4;
    String address;
    String color = "another";

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
