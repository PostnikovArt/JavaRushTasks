package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
//    static {
        public int intVar = 0;
        public double doubleVar = 0d;
    public Double DoubleVar = 0d;
    public boolean booleanVar = false;
    public Object ObjectVar = null;
    public Exception ExceptionVar = null;
    public String StringVar = null;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intVar);
        System.out.println(solution.doubleVar);
        System.out.println(solution.DoubleVar);
        System.out.println(solution.booleanVar);
        System.out.println(solution.ObjectVar);
        System.out.println(solution.ExceptionVar);
        System.out.println(solution.StringVar);
    }
}
