public class Line {
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
}
