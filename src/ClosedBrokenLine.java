import java.util.List;

public class ClosedBrokenLine extends BrokenLine {
    public ClosedBrokenLine(Point... points) {
        super(points);
    }

    public int getLength() {
        if (getPoints().size() == 2) return super.getLength();
        int res = super.getLength();
        List<Point> points = getPoints();
        res += new Line(points.get(points.size() - 1), points.get(0)).length();
        return res;
    }
}
