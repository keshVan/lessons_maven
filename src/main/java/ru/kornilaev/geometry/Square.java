package ru.kornilaev.geometry;

public class Square implements Brokenable {
    Point sp;
    int side;
    public Square(Point startPoint, int sideLength) {
        this.sp = startPoint;
        this.side = sideLength;
    }

    public Square(int x1, int y1, int sideLength) {
        this(new Point(x1, y1), sideLength);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int sideLength) {
        checkPositive(sideLength);
        side = sideLength;
    }

    public double area() {
        System.out.println("calculating");
        return side * side;
    }

    public Point getStartPoint() {
        return sp;
    }

    private void checkPositive(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("length of the side must be positive");
    }

    public String toString() {
        return "Квадрат в точке " + sp + " со стороной " + getSide();
    }

    public BrokenLine getBrokenLine() {
        return new ClosedBrokenLine(sp, new Point(sp.x + getSide(), sp.y), new Point(sp.x + getSide(), sp.y - getSide() ), new Point(sp.x, sp.y - getSide()));
    }
}
