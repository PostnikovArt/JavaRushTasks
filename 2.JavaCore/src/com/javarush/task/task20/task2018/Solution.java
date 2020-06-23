package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable{
    public static class A {

        protected String nameA = "A";

        public A() {
        }

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B() {
        }

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }
        private void writeObject(ObjectOutputStream objectOutputStream) {
            try {
                objectOutputStream.writeObject(this.nameA);
//                objectOutputStream.writeObject(this.nameB);
                objectOutputStream.defaultWriteObject();   //мне кажется !!! defaultWriteObject в любом случае
                // вызывается первым потому, что дефолтный. Поэтому его можно писать и в начале и конце
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void readObject(ObjectInputStream objectInputStream) {

            try {
                this.nameA = (String) objectInputStream.readObject();
//                this.nameB = (String) objectInputStream.readObject();
                objectInputStream.defaultReadObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}