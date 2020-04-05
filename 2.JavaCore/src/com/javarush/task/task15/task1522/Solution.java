package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    static {
        readKeyFromConsoleAndInitPlanet();
        //System.out.println(thePlanet);
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String parameter = reader.readLine();
            thePlanet = null;
            if (parameter.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            }

            if (parameter.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();
                System.out.println(thePlanet);
            }

            if (parameter.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
