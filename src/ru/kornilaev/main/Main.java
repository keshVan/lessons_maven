package ru.kornilaev.main;

import ru.kornilaev.animals.*;
import ru.kornilaev.city.*;
import ru.kornilaev.geometry.*;
import ru.kornilaev.math.Fraction;
import ru.kornilaev.weapons.*;

import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import ru.kornilaev.geometry.Point;

public class Main {
    public static void main(String[] args) {
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new TwoWayCity("D");

        C.putRoad(B, 5);
        C.putRoad(A, 5);
        D.putRoad(A, 5);
        D.putRoad(B, 5);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);

        System.out.println(C.equals(D));
        System.out.println(D.equals(C));
        System.out.println(C.equals(A));
        System.out.println(D.equals(A));
        System.out.println("Hash:");
        System.out.println(C.hashCode() == D.hashCode());
        System.out.println("---------------------------------------------");

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(7, 8);

        BrokenLine line1 = new BrokenLine(p1, p2, p3);
        ClosedBrokenLine line2 = new ClosedBrokenLine(p1, p2, p3);
        BrokenLine line3 = new BrokenLine(p1, p2, p3, p1);
        System.out.print("line1 = line2: ");
        System.out.println(line1.equals(line2));
        System.out.println(line2.equals(line1));
        System.out.print("line2 = line3: ");
        System.out.println(line2.equals(line3));
        System.out.println(line3.equals(line2));
        System.out.print("line1 = line3: ");
        System.out.println(line1.equals(line3));
        System.out.println(line3.equals(line1));
        System.out.print("Hash: ");
        System.out.println(line2.hashCode() == line3.hashCode());
        System.out.println("---------------------------------------------");

        Fraction fraction1 = new Fraction(2, 5);

    }
}