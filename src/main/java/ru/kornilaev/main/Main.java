package ru.kornilaev.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

import ru.kornilaev.geometry.*;
import ru.kornilaev.handlers.ClassReset;
import ru.kornilaev.human.Human;
import ru.kornilaev.handlers.ValidateException;
import ru.kornilaev.reflection.*;
import ru.kornilaev.reflection.Default;
import ru.kornilaev.reflection.Invoke;
import ru.kornilaev.reflection.Validate;

class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        /*----8.1.4---5*/
        /*
        ObjectsWriter ow = new ObjectsWriter("C's.txt");
        ObjectsReader<Point> or = new ObjectsReader<>("C's.txt");
        List<Point> cc = null;
        try {
            ow.write(List.of(/new C("hello", "world"), new C("go", "lang"), new C("peter", "griffin")));
            cc = or.read();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cc);*/
        /*
        Human h1 = new Human("ваня", 150, 25);
        Human h2 = new Human("иван", 150, 25);
        Human h3 = new Human("петр", 10, 25);
        //validate(h1, h2, h3);
        /*(Map<Method, Object> map = collect(A.class);
        for (Map.Entry<Method, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        A a = new A();
        System.out.println(a);
        a.s = "test";
        a.x = 52;
        System.out.println(a);
        ClassReset.reset(a);
        System.out.println(a);*/
        A a = new A();
        TestCache cacheA = CacheProxy.cache(a);
        System.out.println(cacheA.m3());
        System.out.println(cacheA.m3());
        a.x = 128;
        System.out.println(cacheA.m3());
        System.out.println(cacheA.m3());
    }

    public static List<Field> fieldCollection(Class<?> clazz) {
        List<Field> allFields = new ArrayList<>();
        while (clazz != null) {
            Arrays.stream(clazz.getDeclaredFields()).forEach(allFields::add);
            clazz = clazz.getSuperclass();
        }
        return allFields;
    }

    public static void lineConnector(Line<? extends Point> line1, Line<? extends Point> line2) throws NoSuchFieldException, IllegalAccessException {
        Field end1 = line1.getClass().getDeclaredField("end");
        Field start2 = line2.getClass().getDeclaredField("start");
        end1.setAccessible(true);
        start2.setAccessible(true);
        start2.set(line2, end1.get(line1));
    }
}

class B extends A {
    String text = "B";
}

class DefaultA {
    final String s = "hello";
    final int x = 42;
}




