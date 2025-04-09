package ru.kornilaev.post_processors;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.context.ApplicationContext;
import ru.kornilaev.reflection.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToStringProxy {
    private ToStringProxy(){}

    public static <T> T proxy(T obj) {
        if (obj != null) {
            return (T) Enhancer.create(obj.getClass(), new ToStringHandler(obj));
        }
        throw new NullPointerException();
    }

    private static class ToStringHandler implements InvocationHandler {
        Object o;

        public ToStringHandler(Object o) {
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("toString") && method.getParameterCount() == 0) {
                return generateToString();
            }
            return method.invoke(o, args);
        }

        private String generateToString() {
            Class<?> clazz = o.getClass();
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
                                return  f.getName() + "=" + f.get(o);
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
}
