package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String motherName = reader.readLine();
//        Cat catMother = new Cat(motherName);
//
//        String daughterName = reader.readLine();
//        Cat catDaughter = new Cat(daughterName, catMother);
//
//        System.out.println(catMother);
//        System.out.println(catDaughter);

        String grandFatherNme = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherNme);

        String grandMotherNme = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherNme);

        String fatherNme = reader.readLine();
        Cat catFather = new Cat(fatherNme, catGrandFather,null);

        String motherNme = reader.readLine();
        Cat catMother = new Cat(motherNme, null, catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);


        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
//        private Cat parent;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

//        @Override
//        public String toString() {
//            if (parent == null)
//                return "The cat's name is " + name + ", no mother ";
//            else
//                return "The cat's name is " + name + ", mother is " + parent.name;
//        }

        @Override
        public String toString() {
            if (mother == null && father == null)
                return "The cat's name is " + name + ", no mother, no father ";
            else if (mother == null && father != null)
                return "The cat's name is " + name +", no mother, father is " + father.name;
            else if (mother != null && father == null)
                return "The cat's name is " + name +", mother is " + mother.name + ", no father";
            return "The cat's name is " + name + ", mother is " + mother.name + ", father is " +father.name;
        }
    }

}
