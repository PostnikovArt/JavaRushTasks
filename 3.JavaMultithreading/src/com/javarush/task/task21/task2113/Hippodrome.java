package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {

        List<Horse> newHorses = new ArrayList<>();

        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);

        newHorses.add(horse1);
        newHorses.add(horse2);
        newHorses.add(horse3);

        game = new Hippodrome(newHorses);

        game.run();

        game.printWinner();

    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }
    public void print() {
        for (Horse hors : horses) {
            hors.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = new Horse( "", 0, 0);
        for (Horse hors : horses) {
            if (hors.getDistance() > winner.getDistance()) winner = hors;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }

}
