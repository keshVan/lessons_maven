package ru.kornilaev.geometry;

public class Rectangle extends Shape{
    private int side1, side2;

    public Rectangle(Point startPoint, int length, int width) {
        super(startPoint);
        side1 = length;
        side2 = width;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public double area() {
        return side1 * side2;
    }

    public String toString() {
        return "Прямоугольник в точке " + getStartPoint() + ", длины " + side1 + ", ширины " + side2;
    }
}
