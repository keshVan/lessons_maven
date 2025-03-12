package ru.kornilaev.handlers;

import ru.kornilaev.reflection.Default;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class ClassReset {
    private ClassReset(){}

    public static void reset(Object... objects) {
        for (Object o : objects) {
            if (!o.getClass().isAnnotationPresent(Default.class)) continue;
            Class<?> clazz = o.getClass();
            List<Field> fields;
            Class<?> defaultFields;

            if (clazz.isAnnotationPresent(Default.class)) {
                fields = Arrays.stream(clazz.getDeclaredFields())
                        .peek(f -> f.setAccessible(true))
                        .toList();
                defaultFields = clazz.getAnnotation(Default.class).value();
            } else {
                fields = Arrays.stream(clazz.getDeclaredFields())
                        .filter(f -> f.isAnnotationPresent(Default.class))
                        .peek(f -> f.setAccessible(true))
                        .toList();
                if (!fields.isEmpty()) continue;
                defaultFields = fields.getFirst().getAnnotation(Default.class).value();
            }

            Arrays.stream(defaultFields.getDeclaredFields()).forEach(x -> x.setAccessible(true));
            Constructor<?> defaultCnst = null;
            Object defaultObj = null;
            try {
                defaultCnst = defaultFields.getDeclaredConstructor();
                defaultObj = defaultCnst.newInstance();
            } catch (InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            for (Field f : fields) {
                try {
                    System.out.println(f.getName());
                    Field defaultField = defaultFields.getDeclaredField(f.getName());
                    f.set(o, defaultField.get(defaultObj));
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
