import java.util.Arrays;

public class BrokenLine {
    Point[] points;

    public BrokenLine(Point... points) {
        this.points = points;
    }

    public String toString() {
        return "Линия " + Arrays.toString(points);
    }
}
