
        package com.javarush.task.task27.task2712.ad;

        import com.javarush.task.task27.task2712.ConsoleHelper;
        //import com.javarush.task.task27.task2712.statistic.StatisticManager;
        //import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {

        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() > 0)
            {
                advertisements.add(ad);
            }
        }
        if (advertisements.isEmpty()) throw new NoVideoAvailableException();

        Collections.sort(advertisements, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0) {
                    return -result;
                }

                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        int totalDuration = 0;
        long totalAmount = 0;
        List<Advertisement> adsForShow = new ArrayList<>();

        for (Advertisement ad : advertisements) {
            totalAmount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
            if (totalDuration <= timeSeconds && ad.getDuration() <= timeSeconds) adsForShow.add(ad);
            else {
                totalAmount -= ad.getAmountPerOneDisplaying();
                totalDuration -= ad.getDuration();
            }
        }

        //StatisticManager.getInstance().register(new VideoSelectedEventDataRow(adsForShow, totalAmount, totalDuration));

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : adsForShow) {
            if (timeLeft < advertisement.getDuration()) continue;

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }
    }
}


//package com.javarush.task.task27.task2712.ad;
//
//import com.javarush.task.task27.task2712.ConsoleHelper;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class AdvertisementManager {
//    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
//    private int timeSeconds;
//
//    public AdvertisementManager(int timeSeconds) {
//        this.timeSeconds = timeSeconds;
//    }
//
//    public void processVideos() {
//        if (storage.list().isEmpty()) {
//            throw new NoVideoAvailableException();
//        }
//
//        List<Advertisement> videos = storage.list();
//        List<Advertisement> selectedVideos = new ArrayList(); // список для подбора роликов, пока пуст
//        List<Advertisement> current = new ArrayList<>();
//
//        findBest(videos, selectedVideos, current, timeSeconds);
//
//        sortIt(selectedVideos);
//
//        for (Advertisement video : selectedVideos) {
//            long oneSecondValue = video.getAmountPerOneDisplaying() * 1000/ video.getDuration();
//            ConsoleHelper.writeMessage(video.getName() + " is displaying... " + video.getAmountPerOneDisplaying() +
//                    ", " + oneSecondValue);
//            video.revalidate();
//        }
//
////        for (Advertisement video : videos) {
////            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", video.getName(),
////                    video.getAmountPerOneDisplaying(), video.getAmountPerOneDisplaying() * 1000 / video.getDuration()));
////        }
//    }
//
//    private void findBest(List<Advertisement> videos, List<Advertisement> bestVideos,
//                          List<Advertisement> current, int time) {
//        for (Advertisement video : videos) {
//            if (video.getHits() <= 0) continue;
//
//            if ( ! current.contains(video) && (countMark(current, 2) + video.getDuration()) <= time) {
//                current.add(video);
//                List<Advertisement> cloneVideos = new ArrayList<>(videos);
//                cloneVideos.remove(video);
//                findBest(cloneVideos, bestVideos, current, time);
//                current.remove(current.size() -1);
//            }
//        }
//
//        long profitDif = countMark(current, 1) - countMark(bestVideos, 1);
//        long timeDif = countMark(current, 2) - countMark(bestVideos, 2);
//        int roliksif = current.size() - bestVideos.size();
//
//        if (profitDif > 0) {
//            bestVideos.clear();
//            bestVideos.addAll(current);
//        }
//        if (profitDif == 0 && timeDif > 0) {
//            bestVideos.clear();
//            bestVideos.addAll(current);
//        }
//        if (profitDif == 0 && timeDif > 0 && roliksif < 0) {
//            bestVideos.clear();
//            bestVideos.addAll(current);
//        }
//
//    }
//
//    private long countMark(List<Advertisement> videos, int variant) {
//        if (videos.isEmpty()) return 0;
//
//        long sum = 0;
//        for (Advertisement video : videos) {
//            if (variant == 1) {
//                sum += video.getAmountPerOneDisplaying();
//            }
//            if (variant == 2) {
//                sum += video.getDuration();
//            }
//        }
//        return sum;
//    }
//
//    private static void sortIt(List<Advertisement> videos) {
//        class ProfitComparator implements Comparator<Advertisement> {
//            @Override
//            public int compare(Advertisement o1, Advertisement o2) {
//                long value1 = o1.getAmountPerOneDisplaying();
//                long value2 = o2.getAmountPerOneDisplaying();
//                return Long.compare(value1, value2);
//            }
//        }
//        class ValueComparator implements Comparator<Advertisement> {
//            @Override
//            public int compare(Advertisement o1, Advertisement o2) {
//                long value1 = (o1.getAmountPerOneDisplaying()/o1.getDuration() * 1000)/ 1000;
//                long value2 = (o2.getAmountPerOneDisplaying()/o2.getDuration() * 1000)/ 1000;
//                return Long.compare(value1, value2);
//            }
//        }
//        Comparator<Advertisement> advComp = new ProfitComparator().thenComparing(new ValueComparator());
//        Collections.sort(videos, advComp);
//    }
//
//}
