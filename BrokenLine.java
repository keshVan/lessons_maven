package ru.kornilaev.geometry;

import java.util.*;

public class BrokenLine implements Lengthable, Brokenable {
    protected List<Point> points = new ArrayList<>();

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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenLine brokenLine)) return false;
        List<Line> lines1 = getLines();
        List<Line> lines2 = brokenLine.getLines();
        if (lines1.size() != lines2.size()) return false;
        return lines1.equals(lines2) || lines1.equals(brokenLine.getLines().reversed());
    }

    public List<Line> getLines(){
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++)
            lines.add(new Line(points.get(i), points.get(i + 1)));
        return lines;
    }

    @Override
    public int hashCode() {
        int pointsHash = 0;
        for (Point point : points)
            pointsHash += Objects.hash(point);
        return pointsHash;
    }
}
