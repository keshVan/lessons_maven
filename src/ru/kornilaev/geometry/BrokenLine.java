package ru.kornilaev.geometry;

import java.util.*;

public class BrokenLine  {
    protected List<Point> points = new ArrayList<>();

    public BrokenLine() {}

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
        this.points.addAll(points);
    }

    public void addPoint(Point p) {
        this.points.add(p);
    }

   /* public double length() {
        int res = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            res += new Line(points.get(i), points.get(i+1)).length();
        }

        return res;
    }*/

    public BrokenLine getBrokenLine() {
        return this;
    }

   /* public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenLine brokenLine)) return false;
        List<Line> lines1 = getLines();
        List<Line> lines2 = brokenLine.getLines();
        if (lines1.size() != lines2.size()) return false;
        //return lines1.equals(lines2) || lines1.equals(brokenLine.getLines().reversed());
        return true;
    }*/

    /*public List<Line> getLines(){
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++)
            lines.add(new Line(points.get(i), points.get(i + 1)));
        return lines;
    }*/

    @Override
    public int hashCode() {
        int pointsHash = 0;
        for (Point point : points)
            pointsHash += Objects.hash(point);
        return pointsHash;
    }
}
