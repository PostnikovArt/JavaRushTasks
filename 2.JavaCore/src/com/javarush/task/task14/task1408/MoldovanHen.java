package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    @Override
    String getDescription() {
        String string = super.getDescription() + " Моя страна - Moldova. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return string;
    }
}