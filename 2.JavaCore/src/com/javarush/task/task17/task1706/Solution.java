package com.javarush.task.task17.task1706;

/* 
Синхронизированный президент
*/

public class Solution {
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        //System.out.println(expectedPresident);
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident);

    }
}
