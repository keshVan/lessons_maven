import java.util.List;

public class ClosedBrokenLine extends BrokenLine {
    public ClosedBrokenLine(Point... points) {
        super(points);
    }

    public double getLength() {
        if (getPoints().size() == 2) return super.length();
        double res = super.length();
        List<Point> points = getPoints();
        res += new Line(points.get(points.size() - 1), points.get(0)).length();
        return res;
    }
}
