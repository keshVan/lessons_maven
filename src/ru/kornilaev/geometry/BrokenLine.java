package ru.kornilaev.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BrokenLine implements Lengthable, Brokenable {
    private List<Point> points = new ArrayList<>();

    public BrokenLine(Point... points) {
        for (Point p : points)
            this.points.add(p);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public String toString() {
        return "Линия " + points;
    }

    public void addPoints(Point... points) {
        addPoints(Arrays.asList(points));
    }

    public void addPoints(List<Point> points) {
        for (Point p : points)
            this.points.add(p);
    }

    public double length() {
        int res = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            res += new Line(points.get(i), points.get(i+1)).length();
        }

        return res;
    }

    public BrokenLine getBrokenLine() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof BrokenLine)) return false;
        BrokenLine that = (BrokenLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
