package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private int age;
        private boolean sex;
        private ArrayList<Human> parents;
        private HashSet<Human> children;

        public Human(String name) {
            this.name = name;
        }

        public Human(boolean sex, ArrayList<Human> parents) {
            this.sex = sex;
            this.parents = parents;
        }

        public Human(String name, String lastName, int age, boolean sex, ArrayList<Human> parents, HashSet<Human> children) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.parents = parents;
            this.children = children;
        }

        public Human(String name, String lastName, int age, boolean sex, ArrayList<Human> parents) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.parents = parents;
        }

        public Human(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(HashSet<Human> children) {
            this.children = children;
        }

        public Human(ArrayList<Human> parents) {
            this.parents = parents;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }
    }
}
