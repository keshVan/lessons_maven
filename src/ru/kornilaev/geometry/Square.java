package ru.kornilaev.geometry;

public class Square extends Rectangle implements Brokenable {

    public Square(Point startPoint, int sideLength) {
        super(startPoint, sideLength, sideLength);
        checkPositive(sideLength);
    }

    public Square(int x1, int y1, int sideLength) {
        this(new Point(x1, y1), sideLength);
    }

    public int getSide() {
        return super.getSide1();
    }

    public void setSide(int sideLength) {
        checkPositive(sideLength);
        super.setSide1(sideLength);
    }

    private void checkPositive(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("length of the side must be positive");
    }

    public String toString() {
        return "Квадрат в точке " + super.getStartPoint() + " со стороной " + getSide();
    }

    public BrokenLine getBrokenLine() {
        return new ClosedBrokenLine(super.getStartPoint(), new Point(super.getStartPoint().x + getSide(), super.getStartPoint().y), new Point(super.getStartPoint().x + getSide(), super.getStartPoint().y - getSide() ), new Point(super.getStartPoint().x, super.getStartPoint().y - getSide()));
    }
}
