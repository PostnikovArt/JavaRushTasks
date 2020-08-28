package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human human1 = new Human("human1", true, 66);
        Human human2 = new Human("human2", true, 66);
        Human human3 = new Human("human3", true, 66);
        Human human4 = new Human("human4", true, 66);
        Human human5 = new Human("human5", true, 66, human1, human2);
        Human human6 = new Human("human6", true, 66, human3, human4);
        Human human7 = new Human("human7", true, 66, human1,human4);
        Human human8 = new Human("human8", true, 66, human1, human2);
        Human human9 = new Human("human9", true, 66, human2,human4);

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);
        System.out.println(human5);
        System.out.println(human6);
        System.out.println(human7);
        System.out.println(human8);
        System.out.println(human9);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        int age;
        Human father;
        Human mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}