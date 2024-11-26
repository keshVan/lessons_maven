package ru.kornilaev.geometry;


import java.util.List;
import java.util.Objects;

public class Line<T extends Point> implements Lengthable, Brokenable, Cloneable{
    private T start, end;
    private static final int TWO_DIMENSION = 2;

    public Line(T start, T end) {
        this.start = (T) start.clone();
        this.end = (T) end.clone();
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
        List<Integer> coordsStart = start.getCoords();
        List<Integer> coordsEnd = end.getCoords();
        if (coordsStart.size() == TWO_DIMENSION)
            return Math.sqrt( Math.pow(coordsEnd.get(0) - coordsStart.get(0), 2) + Math.pow(coordsEnd.get(1) - coordsStart.get(1), 2) );
        return Math.sqrt( Math.pow(coordsEnd.get(0) - coordsStart.get(0), 2) + Math.pow(coordsEnd.get(1) - coordsStart.get(1), 2) + Math.pow(coordsEnd.get(2) - coordsStart.get(2), 2)  );
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
    }

}
