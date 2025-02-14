package ru.kornilaev.main;

import ru.kornilaev.geometry.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        List<Point> points = List.of(new Point(1, 1), new Point(2, 2));
        List<BrokenLine> bl = Files.lines(Paths.get("resources/test.txt"))
                .map(line -> line.split(" "))
                .map(a -> new Point(Integer.parseInt(a[0]), Integer.parseInt(a[1])))
                .collect(Collectors.groupingBy(p -> p.y))
                .values()
                .stream()
                .map(list -> {
                    BrokenLine tmp = new BrokenLine();
                    for (Point p : list)
                        tmp.addPoint(p);
                    return tmp;
                })
                .toList();

        System.out.println(bl);

    }
}
