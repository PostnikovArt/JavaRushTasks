package com.javarush.task.task27.task2712.ad;

public class Advertisement {

    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        //amountPerOneDisplaying = initialAmount/hits;
        amountPerOneDisplaying = ((hits > 0) ? initialAmount/hits : 0);
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getPricePerOneSecond() {
        return (long) (initialAmount * 1000.0 / duration);
    }

    public void revalidate() {
        if (hits == 1) {
            throw new UnsupportedOperationException();
        } else {
            hits--;
        }
    }
}
