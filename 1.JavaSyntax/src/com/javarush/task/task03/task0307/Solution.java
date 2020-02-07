package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        Zerg zerg  = new Zerg();
//        Zerg zerg1  = new Zerg();
//        Zerg zerg2 = new Zerg();
//        Zerg zerg3  = new Zerg();
//        Zerg zerg4  = new Zerg();
//
//        Protoss protoss = new Protoss();
//        Protoss protoss1 = new Protoss();
//        Protoss protoss2 = new Protoss();
//
//        Terran terran = new Terran();
//        Terran terran1 = new Terran();
//        Terran terran2 = new Terran();
//        Terran terran3 = new Terran();

        for (int i = 0; i < 5; i++) {
            Zerg zerg = new Zerg();
            zerg.name = "" + i;
        }

        for (int i = 0; i < 3; i++) {
            Protoss protoss = new Protoss();
            protoss.name = "a" + i;
        }

        for (int i = 0; i < 4; i++) {
            Terran terran = new Terran();
            terran.name = "b" + i;
        }

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
