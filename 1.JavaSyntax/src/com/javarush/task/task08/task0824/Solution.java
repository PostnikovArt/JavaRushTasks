package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("child1", 1, false);
        Human child2 = new Human("child2", 2, true);
        Human child3 = new Human("child3", 3, false);
        Human mother = new Human("mother", 34, false);
        mother.children = new ArrayList<>(Arrays.asList( child1, child2, child3));
        Human father = new Human("father", 35, true);
        father.children = new ArrayList<>(Arrays.asList( child1, child2, child3));
        Human grandmother1 = new Human("grandmother1", 56, false);
        grandmother1.children = new ArrayList<>(Arrays.asList(mother));
        Human grandmother2 = new Human("grandmother2", 57, false);
        grandmother2.children = new ArrayList<>(Arrays.asList(father));
        Human grandfather1 = new Human("grandfather1", 58, true);
        grandfather1.children = new ArrayList<>(Arrays.asList(mother));
        Human grandfather2 = new Human("grandfather2", 59, true);
        grandfather2.children = new ArrayList<>(Arrays.asList(father));

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(grandfather1);
        System.out.println(grandfather2);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        int age;
        boolean sex;
        ArrayList<Human> children;

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
