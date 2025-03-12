package ru.kornilaev.handlers;

import ru.kornilaev.reflection.Invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collector {
    private Collector(){}

    public static Map<Method, Object> collect(Class<?>... classes) {
        Map<Method, Object> map = new HashMap<>();
        for (Class<?> c : classes) {
            List<Method> methods = Arrays.stream(c.getDeclaredMethods())
                    .filter(m -> m.getParameterCount() == 0)
                    .filter(m -> m.getReturnType() != void.class)
                    .filter(m -> m.isAnnotationPresent(Invoke.class))
                    .peek(m -> m.setAccessible(true))
                    .toList();

            Constructor<?> constructor = null;
            Object obj = null;
            try {
                constructor = c.getDeclaredConstructor();
                obj = constructor.newInstance();
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            for (Method m : methods) {
                try {
                    map.put(m, m.invoke(obj));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return map;
    }
}
