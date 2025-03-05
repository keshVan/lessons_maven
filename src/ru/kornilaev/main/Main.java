package ru.kornilaev.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

import ru.kornilaev.geometry.*;
import ru.kornilaev.human.Human;
import ru.kornilaev.human.ValidateException;
import ru.kornilaev.reflection.*;

class Main {
    public static void main(String[] args) {
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

        Human h1 = new Human("ваня", 150, 25);
        Human h2 = new Human("иван", 150, 25);
        Human h3 = new Human("петр", 10, 25);
        validate(h1, h2, h3);
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

    public static void validate(Object... objects) {
        for (Object o : objects) {
            Class<?> clazz = o.getClass();
            Annotation[] annotations = clazz.getAnnotations();
            Validate annotation = null;
            for (Annotation a : annotations) {
                if (a instanceof Validate v) {
                    annotation = v;
                    break;
                }
                Class<?> curAnn = a.annotationType();
                if (curAnn.isAnnotationPresent(Validate.class)) {
                    annotation = curAnn.getAnnotation(Validate.class);
                    break;
                }
            }
            if (annotation == null) {
                throw new ValidateException(clazz.getSimpleName() + " not annotated with Validate annotation or its aliases");
            }

            Class<?>[] testClasses = annotation.value();
            for (Class<?> testClass : testClasses) {
                Constructor<?> constructor = null;
                Object test = null;
                List<Method> tests = Arrays.stream(testClass.getDeclaredMethods())
                        .filter(m -> m.getParameterCount() == 1)
                        .filter(m -> m.getParameterTypes()[0].isAssignableFrom(clazz))
                        .peek(m -> m.setAccessible(true))
                        .toList();

                try {
                    constructor = testClass.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    test = constructor.newInstance();
                    for (Method m : tests) {
                        m.invoke(test, o);
                    }
                }
                catch (InvocationTargetException e) {
                    if (e.getCause() instanceof ValidateException ve) {
                        throw ve;
                    }
                    throw new RuntimeException(e);
                }
                catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


class A extends Entity {
    String s = "hello";
    @ToString(false)
    int x = 42;
}

class B extends A {
    String text = "B";
}




