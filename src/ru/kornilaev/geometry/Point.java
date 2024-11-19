package ru.kornilaev.geometry;

<<<<<<< HEAD
import ru.kornilaev.math.Fraction;

import java.util.Objects;

public class Point implements Comparable<Point>, Cloneable {
=======
import java.util.Objects;

public class Point implements Comparable<Point> {
>>>>>>> refs/remotes/origin/master
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(){};

    public Point(Point p) {
        this(p.x, p.y);
    }


    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) return p.y - this.y;
        return p.x - this.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
<<<<<<< HEAD
    public Point clone(){
        try {
            return (Point) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
=======
>>>>>>> refs/remotes/origin/master
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
