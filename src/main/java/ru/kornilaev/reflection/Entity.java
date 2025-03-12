package ru.kornilaev.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Entity {
    @Override
    public String toString() {
        Class<?> clazz = this.getClass();
        String res = clazz.getSimpleName() + "{";
        List<String> fields = new ArrayList<>();

        while (clazz != null) {
            List<Field> curFields;
            if (clazz.isAnnotationPresent(ToString.class) && !clazz.getAnnotation(ToString.class).value()) {
                curFields = Arrays.stream(clazz.getDeclaredFields())
                        .filter(f -> f.isAnnotationPresent(ToString.class) && f.getAnnotation(ToString.class).value())
                        .toList();
            }
            else {
                curFields = Arrays.stream(clazz.getDeclaredFields())
                        .filter(f -> !f.isAnnotationPresent(ToString.class) || f.getAnnotation(ToString.class).value())
                        .toList();
            }
            curFields.stream()
                    .peek(f -> f.setAccessible(true))
                    .map(f -> {
                        try {
                            return  f.getName() + "=" + f.get(this);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .forEachOrdered(fields::add);
            clazz = clazz.getSuperclass();
        }
        return res + String.join(",", fields) + "}";
    }
}



