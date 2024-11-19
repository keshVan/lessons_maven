package ru.kornilaev.geometry;

import java.util.Objects;

public class Line implements Lengthable, Brokenable{
    private Point start = new Point();
    private Point end = new Point();

    public Line(Point start, Point end) {
        this(start.x, start.y, end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start.x = x1;
        this.start.y = y1;
        this.end.x = x2;
        this.end.y = y2;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start.x = start.x;
        this.start.y = start.y;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end.x = end.x;
        this.end.y = end.y;
    }

    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public double length() {
        return Math.sqrt( Math.pow(end.x - start.y, 2) + Math.pow(end.x - start.y, 2) );
    }

    @Override
    public BrokenLine getBrokenLine() {
        return new BrokenLine(start, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Objects.equals(start, line.start) && Objects.equals(end, line.end)) || (Objects.equals(end, line.start) && Objects.equals(start, line.end));
    }

    @Override
<<<<<<< HEAD
    public Line clone() {
        try {
            Line line = (Line) super.clone();
            line.start = start.clone();
            line.end = end.clone();
            return line;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(start) + Objects.hashCode(end);
=======
    public int hashCode() {
        return Objects.hash(start) + Objects.hash(end);
>>>>>>> refs/remotes/origin/master
    }
}
