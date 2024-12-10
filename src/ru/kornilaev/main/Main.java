package ru.kornilaev.main;

import ru.kornilaev.generics.*;
import ru.kornilaev.math.Fraction;
import ru.kornilaev.geometry.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>(List.of(new Point(1, 2), new Point(3, 4), new Point(5, 6)));
        BrokenLine line = DataStream.of(points)
                .filter((p) -> p.x > 1)
                .map((p) -> p.x += 10)
                .collect(BrokenLine::new, (l, p) -> l.addPoint(p));
        System.out.println(line);
    }

    public static void shiftLine(Line<? extends Point> line) {

        Point p = line.getStart();
        if (p.x >= 0)
            p.x += 10;
        else
            p.x -= 10;

    }

    public static double sumBoxes(Box<? extends Number>... boxes) {
        double max = boxes[0].get().doubleValue();
        for (int i = 1; i < boxes.length; i++) {
            double value = boxes[i].get().doubleValue();
            if (max < value) max = value;
        }
        return max;
    }

    public static void putPoint(Box box) {
        box.set(new Point3D(1, 1, 1));
    }

    public static void fillList(List<Number> list) {
        for (int i = 1; i < 101; i ++)
            list.add(i);
    }
}






