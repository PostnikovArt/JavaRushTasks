package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solutions = new Solution[2];
        for (int i = 0; i < 2; i++) {
            Solution solution = new Solution();
            solution.innerClasses = getArray();
            solutions[i] = solution;
        }

        return solutions;
    }
     static InnerClass[] getArray() {
        InnerClass[] innerClasses = new InnerClass[2];
        innerClasses[0] = new InnerClass();
        innerClasses[1] = new InnerClass();
        return innerClasses;
    }

    public static void main(String[] args) {

    }
}
