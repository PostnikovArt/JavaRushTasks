package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> videos = new ArrayList(); // список для подбора роликов, пока пуст

        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        for (Advertisement video : videos) {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", video.getName(),
                    video.getAmountPerOneDisplaying(), video.getAmountPerOneDisplaying() * 1000 / video.getDuration()));
        }
    }
}
