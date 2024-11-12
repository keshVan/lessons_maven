package ru.kornilaev.geometry;

public class Point2D extends AbstractPoint {
    private static final int DIMENSION = 2;
    private static final int INDEX_X = 0;
    private static final int INDEX_Y = 1;

    public Point2D(int x, int y, Attribute... attributes) {
        super(DIMENSION, attributes);
        coordinates[INDEX_X] = x;
        coordinates[INDEX_Y] = y;
    }

    public int getX() {
        return coordinates[INDEX_X];
    }

    public int getY() {
        return coordinates[INDEX_Y];
    }

    public void setX(int x) {
        coordinates[INDEX_X] = x;
    }

    public void setY(int y) {
        coordinates[INDEX_Y] = y;
    }
}
