package ru.kornilaev.geometry;

public class Point1D extends AbstractPoint {
    private static final int DIMENSION = 1;
    private static final int INDEX_X = 0;

    public Point1D(int x, Attribute... attributes) {
        super(DIMENSION, attributes);
        coordinates[INDEX_X] = x;
    }

    public int getX() {
        return coordinates[INDEX_X];
    }
}
