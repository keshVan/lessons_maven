package ru.kornilaev.main;

import ru.kornilaev.generics.*;
import ru.kornilaev.stack.Stack;
import ru.kornilaev.student.Student;
import ru.kornilaev.geometry.*;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.set(3);
        testBox(box);
        System.out.println("----------------------------------");

        Storage<Number> storage1 = new Storage<>(null, 0);
        Storage<Number> storage2 = new Storage<>(99, -1);
        Storage<String> storage3 = new Storage<>(null, "default");
        Storage<String> storage4 = new Storage<>("hello", "hello world");
        testStorage(storage1);
        testStorage(storage2);
        testStorage(storage3);
        testStorage(storage4);


        Student std1 = new Student("вася", 5, 4, 5, 4, 5, 4, 4, 5);
        Student std2 = new Student("петя", 3, 4, 2, 4, 3, 4, 4, 5);
        System.out.println(std1.compare(std2));
        System.out.println("----------------------------------");

        Line<Point3D> line = new Line<>(new Point3D(1, 1, 1), new Point3D(2, 2, 2));
        System.out.println(line);
        line.setStart(new Point3D(3,3, 3));
        System.out.println(line.length());
        System.out.println("----------------------------------");

        Stack<Integer> stack = new Stack<>(1, 2, 3, 4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }

    public static void testBox(Box box) {
        System.out.println(box.get());
    }

    public static void testStorage(Storage storage) {
        System.out.println(storage.getObject());
    }
}

