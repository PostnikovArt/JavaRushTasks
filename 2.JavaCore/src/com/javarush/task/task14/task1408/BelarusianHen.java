package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    String getDescription() {
        String string = super.getDescription() + " Моя страна - Belarus. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return string;
    }
}
