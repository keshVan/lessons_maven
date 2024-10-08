import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrokenLine {
    Point[] points;

    public BrokenLine(){};

    public BrokenLine(Point... points) {
        this.points = points;
    }

    public String toString() {
        return "Линия " + Arrays.toString(points);
    }

    public void addPoints(Point... p) {
        Point[] newPoints = Arrays.copyOf(points, points.length + p.length);
        for (int i = points.length; i < points.length + p.length; i++) {
            newPoints[i] = p[i-points.length];
        }
        points = newPoints;
    }

    public int getLength() {
        int res = 0;

        for (int i = 0; i < points.length - 1; i++) {
            res += getLengthPart(points[i], points[i + 1]);
        }

        return res;
    }

    private int getLengthPart(Point start, Point end) {
        return (int)Math.sqrt( Math.pow(end.x - start.x, 2) + Math.pow(end.y - start.y, 2) );
    }
}
