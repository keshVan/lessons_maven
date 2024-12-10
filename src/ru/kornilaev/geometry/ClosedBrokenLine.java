package ru.kornilaev.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClosedBrokenLine extends BrokenLine {
    public ClosedBrokenLine(Point... points) {
        super(points);
    }

    //public double getLength() {
       // if (getPoints().size() == 2) return super.length();
      //  double res = super.length();
        //List<Point> points = getPoints();
       // res += new Line(points.get(points.size() - 1), points.get(0)).length();
       // return res;
    //}

    //public List<Line> getLines(){
        //List<Line> lines = super.getLines();
    //    //lines.add(new Line(points.get(0), points.get(points.size() - 1)));
       // return lines;
    //}

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(points.get(0));
    }
}
