public class Time {
    private int seconds;

    public Time(int seconds) {
        checkNegative(seconds);
        this.seconds = seconds > 86400 ? seconds - 86400 : seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        this(hours * 3600 + minutes * 60 + seconds);
    }

    public void setSeconds(int seconds) {
        checkNegative(seconds);
        this.seconds = seconds;
    }

    private void checkNegative(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("seconds must be non-negative");
    }

    public int getSeconds() {
        return seconds;
    }

    public String toString() {

        int hours = this.seconds / 3600;
        int minutes = this.seconds  % 3600 / 60;
        int seconds = this.seconds  % 3600 % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public int lastHour() {
        return seconds / 3600;
    }

    public int lastMinute() {
        return seconds % 3600 / 60;
    }

    public int lastSecond() {
        return seconds % 3600 % 60;
    }
}
