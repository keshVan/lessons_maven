package ru.kornilaev.main;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.util.*;

import ru.kornilaev.geometry.*;
import ru.kornilaev.human.Human;
import ru.kornilaev.student.Student;

class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        /*----8.1.2----*/
        Line<Point> line1 = Line.of(1, 2, 3, 4);
        Line<Point> line2 = Line.of(3, 4, 5, 6);
        System.out.println(line1.getEnd() == line2.getStart());
        try {
            lineConnector(line1, line2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(line1.getEnd() == line2.getStart());
        System.out.println();

        /*----8.1.3----*/
        B b = new B();
        System.out.println(b);
        System.out.println();

        /*----8.1.4---*/
        Human h = new Human("иван", 175, 70);
        try {
            validate(h, HumanTests.class);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        /*----8.1.4---5*/
        ObjectsWriter ow = new ObjectsWriter("C's.txt");
        ObjectsReader<Point> or = new ObjectsReader<>("C's.txt");
        List<Point> cc = null;
        try {
            ow.write(List.of(new C("hello", "world"), new C("go", "lang"), new C("peter", "griffin")));
            cc = or.read();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cc);
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

    public static void validate(Object o, Class<?> tester) throws InvocationTargetException, IllegalAccessException {
        Method[] tests = tester.getDeclaredMethods();
        for (Method m : tests) {
            m.setAccessible(true);
            if (!(boolean)m.invoke(null, o))
                throw new ValidateException("ошибка в " + m.getName() + ": " + m.getAnnotation(ErrorMessage.class).value());
        }
    }
}

abstract class Entity {
    @Override
    public String toString() {
        Class<?> clazz = this.getClass();
        StringBuilder sb = new StringBuilder(clazz.getSimpleName()+"{");

        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                try {
                    sb.append(f.getName()).append("=").append(f.get(this)).append(",").append(" ");
                } catch (IllegalAccessException e) {
                    sb.append(f.getName()).append("=").append("err").append(",").append(" ");
                }
            }
            clazz = clazz.getSuperclass();
        }
        sb.replace(sb.length() - 2, sb.length() - 1, "}");
        return sb.toString();
    }
}

class A extends Entity {
    String s = "hello";
    int x = 42;
}

class B extends  A {
    String text = "B";
}


class HumanTests {
    @ErrorMessage("рост человека не в диапазоне от 50 до 250")
    public static boolean test1(Human h) {
        return h.getHeight() >= 50 && h.getHeight() <= 250;
    }

    @ErrorMessage("возраст человека не в диапазоне от 1 до 200")
    public static boolean test2(Human h) {
        return h.getAge() >= 1 && h.getAge() <= 200;
    }
}

class ValidateException extends RuntimeException {
    public ValidateException(String value) {
        super(value);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ErrorMessage {
    String value();
}

class C {
    String field1;
    String field2;

    public C(){}

    public C(String f1, String f2) {
        field1 = f1;
        field2 = f2;
    }

    @Override
    public String toString() {
        return "{" + field1 + ";" + field2 + "}";
    }
}
