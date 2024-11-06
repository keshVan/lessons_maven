import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.x == p2.x) return p1.y - p2.y;
        return p1.x - p2.x;
    }
}
