package ru.kornilaev.main;

import ru.kornilaev.generics.*;
import ru.kornilaev.math.Fraction;
import ru.kornilaev.geometry.*;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Line<Point3D> line = new Line<>(new Point3D(1, 1, 1), new Point3D(2, 2, 2));
        System.out.println(line);
        shiftLine(line);
        System.out.println(line);
        Line<Point> line2 = new Line<>(new Point(-5, 1), new Point(1, 2));
        System.out.println(line2);
        shiftLine(line2);
        System.out.println(line2);
        System.out.println("-------------------------------------");

        Box<Fraction> fractionBox = new Box<>();
        fractionBox.set(new Fraction(7,4));

        Box<Integer> integerBox = new Box<>();
        integerBox.set(5);

        Box<Double> doubleBox = new Box<>();
        doubleBox.set(3.2);

        System.out.println(sumBoxes(fractionBox, integerBox, doubleBox));
        System.out.println("-------------------------------------");

        Box<Integer> box2 = new Box<>();
        putPoint(box2);
        System.out.println(box2.get());
        System.out.println("-------------------------------------");
        List<Number> list3 = new ArrayList<>();
        fillList(list3);
        System.out.println(list3);

        System.out.println("6.3.1-------------------------------------");

        List<String> stringList = new ArrayList<>(List.of("qwerty", "asdfg", "zx"));
        List<Integer> stringLengths = func(stringList, a -> a.length());
        System.out.println(stringLengths);

        List<Integer> integerList = new ArrayList<>(List.of(1, -3, 7));
        List<Integer> newIntegerList = func(integerList, a -> Math.abs(a));
        System.out.println(newIntegerList);
        int[] arr = new int[]{1, 2, 3, 4};

        List<int[]> listOfArrays = new ArrayList<>(List.of(new int[]{1, 5, 7}, new int[]{23, -5, 1}, new int[]{-9, 1, 3}));
        List<Integer> newListOfArrays = func(listOfArrays, (int[] a) -> {
            int max = a[0];
            for (int i = 0; i < a.length; i++)
                if (max < a[i]) max = a[i];
            return max;
        });
        System.out.println(newListOfArrays);

        System.out.println("6.3.2-------------------------------------");

        List<String> newStringList = filter(stringList, a -> a.length() < 3);
        System.out.println(newStringList);

        newIntegerList = filter(integerList, a -> a > 0);
        System.out.println(newIntegerList);

        List<List<Integer>> lists = new ArrayList<>(List.of(List.of(1, -5, 7), List.of(-23, -5, -1), List.of(-9, 1, 3)));
        List<List<Integer>> newListOfArrays2 = filter(lists, (a) -> {
            for (int i : a)
                if (i > 0) return false;
            return true;
        } );
        System.out.println(newListOfArrays2);
        System.out.println("6.3.3-------------------------------------");

        String string = reduction(stringList, (a) -> {
            String res = "";
            for (String s : a)
                res += s;
            return res;
        });
        System.out.println(string);

        int sum = reduction(integerList, (a) -> {
            int res = 0;
            for (int i : a)
                res += i;
            return res;
        });
        System.out.println(sum);


        int res = reduction(listOfArrays, new Reductiable<>(){
        });


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

    public static <T, P> List<P> func(List<T> list, Appliable<T, P> a) {
        List<P> res = new ArrayList<>();
        for (T el : list)
            res.add(a.apply(el));
        return res;
    }

    public static <T> List<T> filter(List<T> list, Testable<T> a) {
        List<T> res = new ArrayList<>();
        for (T el : list)
            if(a.test(el))
                res.add(el);
        return res;
        Supplier
    }

    public static <T> T reduction(List<T> list, Reductiable<T> a) {
        return a.reduct(list);
    }
}

interface Appliable<T, P> {
    P apply(T el);
}

interface Testable<T> {
    boolean test(T el);
}

interface Reductiable<T> {
    T reduct(List<T> el);
}




/*class ToPositive<T extends Number> implements Appliable<T, T> {
    @Override
    public T apply(Number el) {
        return (T) Math.abs(el.doubleValue());
    }
}*/


