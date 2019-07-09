package com.app.quiz2;

public class Difficulty {
    public static float getDif() {
        return dif;
    }

    public static void increaseDif() {
        Difficulty.dif++;
    }

    private static float dif=1;

}
