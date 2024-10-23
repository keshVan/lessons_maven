public class Square extends Shape {
    private int sideLength;

    public Square(Point startPoint, int sideLength) {
        super(startPoint);
        checkPositive(sideLength);
        this.sideLength = sideLength;
    }

    public Square(int x1, int y1, int sideLength) {
        this(new Point(x1, y1), sideLength);
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        checkPositive(sideLength);
        this.sideLength = sideLength;
    }

    public double area() {
        return sideLength * sideLength;
    }

    private void checkPositive(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("length of the side must be positive");
    }

    public String toString() {
        return "Квадрат в точке " + super.getStartPoint() + " со стороной " + sideLength;
    }

    public BrokenLine getBrokenLine() {
        return new BrokenLine(super.getStartPoint(), new Point(super.getStartPoint().x + sideLength, super.getStartPoint().y), new Point(super.getStartPoint().x + sideLength, super.getStartPoint().y - sideLength ), new Point(super.getStartPoint().x, super.getStartPoint().y - sideLength));
    }
}
