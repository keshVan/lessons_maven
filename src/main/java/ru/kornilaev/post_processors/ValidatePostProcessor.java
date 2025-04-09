package ru.kornilaev.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.kornilaev.handlers.ValidateException;
import ru.kornilaev.reflection.Validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Component
public class ValidatePostProcessor implements BeanPostProcessor {
    private final ApplicationContext ctx;

    public ValidatePostProcessor(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
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
            return bean;
        }

        Object test = ctx.getBean(annotation.value());

        List<Method> tests = Arrays.stream(test.getClass().getDeclaredMethods())
                .filter(m -> m.getParameterCount() == 1)
                .filter(m -> m.getParameterTypes()[0].isAssignableFrom(clazz))
                .peek(m -> m.setAccessible(true))
                .toList();

        try {
            for (Method m : tests) {
                m.invoke(test, bean);
            }
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof ValidateException ve) {
                throw ve;
            }
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return bean;
    }
}
