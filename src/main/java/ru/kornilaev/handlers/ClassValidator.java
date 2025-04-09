package ru.kornilaev.handlers;

import ru.kornilaev.reflection.Validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ClassValidator {
    private ClassValidator() {}

    public static void validate(Object... objects) {
       /* for (Object o : objects) {
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
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof ValidateException ve) {
                        throw ve;
                    }
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        } */
    }
}
