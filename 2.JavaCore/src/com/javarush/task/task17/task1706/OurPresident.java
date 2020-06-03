package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (new Object()) {
//            System.out.println("ggggggggggg");
//            if (president.equals(null)) {     //сравнивал нулевую ссылку по методу!!!!!! equals  позор!!!!
//                System.out.println("aaaaaaaaaaa");
//                president = new OurPresident();
//            }
            president = new OurPresident();

        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
