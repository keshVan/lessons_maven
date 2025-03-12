package ru.kornilaev.geometry;

public class SquareCache extends Square {
    Square square;
    double area;

    boolean refresh = true;

    public SquareCache(Square square) {
        super(square.getStartPoint(), square.getSide());
        this.square = square;
    }

    public double area() {
        if (refresh) area = square.area();
        refresh = false;
        return area;
    }

    public void setSide(int x) {
        square.setSide(x);
        refresh = true;
    }
}
