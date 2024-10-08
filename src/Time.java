public class Time {
    int seconds;

    public Time(int seconds) {
        this.seconds = seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        this(hours * 3600 + minutes * 60 + seconds);
    }

    public String toString() {
        int tempSeconds = seconds > 3600 * 24 ? seconds - 3600 * 24 : seconds;

        int hours = tempSeconds / 3600;
        int minutes = tempSeconds % 3600 / 60;
        int seconds = tempSeconds % 3600 % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public int getHour() {
        return seconds / 3600;
    }

    public int getMinute() {
        return seconds % 3600 / 60;
    }

    public int getSeconds() {
        return seconds % 3600 % 60;
    }
}
