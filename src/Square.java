public class Square {
    private Point startPoint;
    private int sideLength;

    public Square(Point startPoint, int sideLength) {
        checkPositive(sideLength);
        this.startPoint = startPoint;
        this.sideLength = sideLength;
    }

    public Square(int x1, int y1, int sideLength) {
        this(new Point(x1, y1), sideLength);
    }

    public Point getStartPoint() {
        return new Point(startPoint);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        checkPositive(sideLength);
        this.sideLength = sideLength;
    }

    private void checkPositive(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("length of the side must be positive");
    }

    public String toString() {
        return "Квадрат в точке " + startPoint + " со стороной " + sideLength;
    }

    public BrokenLine getBrokenLine() {
        return new BrokenLine(startPoint, new Point(startPoint.getX() + sideLength, startPoint.getY()), new Point(startPoint.getX() + sideLength, startPoint.getY() - sideLength ), new Point(startPoint.getX(), startPoint.getY() - sideLength));
    }
}
