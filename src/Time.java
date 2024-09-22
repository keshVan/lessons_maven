public class Time {
    public int seconds;

    public String toString() {
        int tempSeconds = seconds > 3600 * 24 ? seconds - 3600 * 24 : seconds;

        int hours = tempSeconds / 3600;
        int minutes = tempSeconds % 3600 / 60;
        int seconds = tempSeconds % 3600 % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
