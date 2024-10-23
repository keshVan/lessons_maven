public class Rectangle extends Shape{
    private Line side1, side2;

    public Rectangle(Point startPoint, int length, int width) {
        super(startPoint);
        side1 = new Line(startPoint.x, startPoint.y, startPoint.x + length, startPoint.y);
        side2 = new Line(startPoint.x, startPoint.y, startPoint.x, startPoint.y - width);
    }

    public double area() {
        return side1.length() * side2.length();
    }

    public String toString() {
        return "Прямоугольник в точке " + getStartPoint() + ", длины " + side1.length() + ", ширины " + side2.length();
    }
}
