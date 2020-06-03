package com.javarush.task.task02.task0217;

/* 
Минимум четырех чисел
*/
public class Solution {
    public static int min(int a, int b, int c, int d) {
        //напишите тут ваш код
        min(a,b);
        if ((a <= b)&&(a <= c)&&(a <= d)) return a;
        if ((b <= a)&&(b <= c)&&(b <= d)) return b;
        if ((c <= a)&&(c <= b)&&(c <= d)) return c;
        return d;

        //return min(a, min(b, min(c,d)));  лучшее решение !!!!!
    }

    public static int min(int a, int b) {
        //напишите тут ваш код
        if (a <= b) return a;
        else return b;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(-20, -10));
        System.out.println(min(-40, -10, -30, 40));
        System.out.println(min(-20, -40, -30, 40));
        System.out.println(min(-20, -10, -40, 40));
        System.out.println(min(-20, -10, -30, -40));
    }
}