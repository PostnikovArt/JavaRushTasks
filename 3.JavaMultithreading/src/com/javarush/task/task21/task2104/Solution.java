package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
//        return n.first.equals(first) && n.last.equals(last);
        if (this == n) return true;
        if (n == null) return false;
        if ( !(n instanceof Solution)) return false;
        Solution solution = (Solution)n;
        if (this.first == null && this.last == null )  return solution.first == null && solution.last == null;
        if (this.first != null && this.last == null )  return solution.first.equals(this.first) && solution.last == null;
        if (this.first == null && this.last != null )  return solution.first == null && solution.last.equals(this.last);
        return this.first.equals(solution.first) && this.last.equals(solution.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

//    public int hashCode() {
//        return 31 * first.length() * last.length() * 1111;
//    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
//        System.out.println(new Solution("Donald", "Duck").first.equals(new Solution("Donald", "Dck").first));
        System.out.println(new Solution("Donald", "Dck").hashCode());
    }
}
