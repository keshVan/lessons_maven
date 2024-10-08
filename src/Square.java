public class Square {
    Point startPoint;
    int sideLength;

    public Square(Point startPoint, int sideLength) {
        this.startPoint = startPoint;
        this.sideLength = sideLength;
    }

    public Square(int x1, int y1, int sideLength) {
        this(new Point(x1, y1), sideLength);
    }

    public String toString() {
        return "Квадрат в точке " + startPoint + " со стороной " + sideLength;
    }

    public BrokenLine getBrokenLine() {
        return new BrokenLine(startPoint, new Point(startPoint.x + sideLength, startPoint.y), new Point(startPoint.x + sideLength, startPoint.y - sideLength ), new Point(startPoint.x, startPoint.y - sideLength));
    }
}
