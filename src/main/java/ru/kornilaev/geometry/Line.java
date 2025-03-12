package ru.kornilaev.geometry;


import java.util.Objects;

public class Line<T extends Point> implements Lengthable, Brokenable, Cloneable{
    private T start, end;

    private Line(T start, T end) {
        this.start = (T) start.clone();
        this.end = (T) end.clone();
    }

    public static Line<Point> of(int x1, int y1, int x2, int y2) {
        return new Line<>(new Point(x1, y1), new Point(x2, y2));
    }

    public static <V extends Point> Line<V> of(V p1, V p2){
        return new Line<>(p1, p2);
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = (T) start.clone();
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = (T) end.clone();
    }

    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public double length() {
        return start.distanceTo(end);
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
    public Line<T> clone() {
        try {
            Line<T> line = (Line<T>) super.clone();
            line.start = (T)start.clone();
            line.end = (T)end.clone();
            return line;
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(start) + Objects.hashCode(end);
    }

}
