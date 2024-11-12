package ru.kornilaev.geometry;

public abstract class Shape {
    private Point startPoint;

    public Shape(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public abstract double area();
}
