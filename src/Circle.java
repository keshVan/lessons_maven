public class Circle extends Shape{
    private int radius;

    public Circle(Point center, int radius) {
        super(center);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return super.getStartPoint();
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Окружность в точке " + getStartPoint() + " c радиусом " + radius;
    }
}
