package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public final class Clock {
    private static Clock c ; 
    private final int time = new Random().nextInt(25);

    private Clock() {
    }

    public static Clock getClock() {
        if (c == null) {
            c = new Clock();
        }
        return c;
    }

    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }
}
