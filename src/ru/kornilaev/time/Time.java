package ru.kornilaev.time;

public class Time {
    private int totalSeconds;
    public static final int SECONDS_IN_MINUTES = 60;
    public static final int SECONDS_IN_HOURS = 3600;
    public static final int SECONDS_IN_DAY = 86400;

    public Time(int seconds) {
        this(0, 0, seconds);
    }

    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0)
            throw new IllegalArgumentException("time must be non-negative");
        this.totalSeconds = hours * SECONDS_IN_HOURS + minutes * SECONDS_IN_MINUTES + seconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        if (totalSeconds < 0)
            throw new IllegalArgumentException("seconds must be non-negative");
        this.totalSeconds = totalSeconds;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }


    public String toString() {
        return String.format("%02d:%02d:%02d", hours(), minutes(), seconds());
    }

    public int hours() {
        return totalSeconds / SECONDS_IN_HOURS;
    }

    public int minutes() {
        return totalSeconds % SECONDS_IN_HOURS / SECONDS_IN_MINUTES;
    }

    public int seconds() {
        return totalSeconds % SECONDS_IN_HOURS % SECONDS_IN_MINUTES;
    }
}
