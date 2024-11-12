package ru.kornilaev.main;

import ru.kornilaev.animals.*;
import ru.kornilaev.city.*;
import ru.kornilaev.geometry.*;
import ru.kornilaev.math.Fraction;
import ru.kornilaev.weapons.*;

import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import ru.kornilaev.geometry.Point;

public class Main {
    public static void main(String[] args) {
        System.out.println(Methods.sum(2, new Fraction(3,5), 2.3));
        System.out.println(Methods.sum(3.6, new Fraction(49,12), 3, new Fraction(3,2)));
        System.out.println(Methods.sum(new Fraction(1, 3), 1));
        System.out.println("--------------------------------------------");

        Methods.birdsShop(new Sparrow(), new Cuckoo(), new Parrot("меня зовут Вито Скаллето"));
        System.out.println("--------------------------------------------");

        System.out.println(Methods.totalArea(new Circle(new Point(1, 1), 5), new Circle(new Point(5, 5), 7), new Square(new Point(7, 7), 3)));
        System.out.println("--------------------------------------------");

        Methods.meows(new Cat("пушок"), new Cat("чювачок"), new Tiger());
        System.out.println("--------------------------------------------");

        System.out.println(Methods.totalLength(new Line(1, 1, 2, 3), new Line(5, 1, 7, 1), new BrokenLine(new Point(1, 1), new Point(7, 3), new Point(2, 1))));
        System.out.println("--------------------------------------------");

        System.out.println(Methods.getBrokenLine(new Square(new Point(1, 1), 5), new Triangle(new Point(3, 4), new Point(5, 6), new Point(7, 8)), new Line(10, 11, 12, 13)));
        System.out.println("--------------------------------------------");

        Gunslinger bob = new Gunslinger("Боб");
        Gunslinger joe = new Gunslinger("Джо", new Gun());
        Gunslinger john = new Gunslinger("Боб", new Rifle());
        System.out.println("Стреляет Боб:");
        bob.shoot();
        System.out.println("--------------------------------------------");
        System.out.println("Стреляет Джо:");
        joe.shoot();
        System.out.println("--------------------------------------------");
        System.out.println("Стреляет Джон:");
        john.shoot();
        System.out.println("--------------------------------------------");

        TwoWayCity a =  new TwoWayCity("A");
        City b =  new City("B");
        City c =  new City("C");
        TwoWayCity d =  new TwoWayCity("D");
        City e = new City("E");
        a.putRoad(b, 1);
        a.putRoad(c, 1);
        b.putRoad(c, 1);
        d.putRoad(b, 1);
        d.putRoad(e, 1);
        e.putRoad(c, 1);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println("--------------------------------------------");

        System.out.println(Methods.sum(7, new Fraction(11, 3), 3.21, new BigInteger("12345678912345678912")));
        System.out.println("--------------------------------------------");

        System.out.println(pow(parseInt(args[0]), parseInt(args[1])));
        System.out.println("--------------------------------------------");

        System.out.println("ru.kornilaev.geometry.Point: " + new Point(1, 1));
        System.out.println(new java.awt.Point(2, 2));

    }
}