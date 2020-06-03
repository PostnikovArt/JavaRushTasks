package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {



    @Override
    int getCountOfEggsPerMonth() {
        return 1;
    }

    @Override
    String getDescription() {
        String string = super.getDescription() + " Моя страна - Russia. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return string;
    }
}
