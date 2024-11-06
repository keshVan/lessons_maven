public class Triangle extends Shape implements Brokenable {
    private Point p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        super(p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    public double area() {
        Line side1 = new Line(getStartPoint(), p2);
        Line side2 = new Line(p2, p3);
        Line side3 = new Line(getStartPoint(),  p3);
        double p = (side1.length() + side2.length() + side3.length()) / 2;

        return Math.sqrt(p * (p - side1.length()) * (p - side2.length()) * (p - side3.length()));
    }

    public String toString() {
        return "Треугольник в точках " + getStartPoint() + ", " + p2 + ", " + p3;
    }

    @Override
    public BrokenLine getBrokenLine() {
        return new BrokenLine(new Point(getStartPoint()), p2, p3);
    }
}
