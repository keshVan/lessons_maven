package ru.kornilaev.post_processors;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.context.ApplicationContext;
import ru.kornilaev.reflection.Default;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResetProxy {

    private ResetProxy(){}

    public static <T> T proxy(T obj, ApplicationContext ctx) {
        if (obj != null) {
            return (T) Enhancer.create(obj.getClass(), obj.getClass().getInterfaces(), new ResetHandler(obj, ctx));
        }
        throw new NullPointerException();
    }

    private static class ResetHandler implements InvocationHandler {
        Object o;
        List<Field> fields;
        ApplicationContext ctx;

        public ResetHandler(Object o, ApplicationContext ctx) {
            this.o = o;
            this.ctx = ctx;
            fields = collectFields(o.getClass());
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("reset") && method.getParameterCount() == 0) {
                return reset(proxy, method, args);
            }
            return method.invoke(o, args);
        }

        private List<Field> collectFields(Class<?> clazz) {
            if (clazz.isAnnotationPresent(Default.class)) {
                return Arrays.stream(clazz.getDeclaredFields())
                        .peek(f -> f.setAccessible(true))
                        .toList();
            }
            return Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(Default.class))
                    .peek(f -> f.setAccessible(true))
                    .toList();
        }

        private Object reset(Object proxy, Method m, Object[] args) throws Throwable {
            if (o.getClass().isAnnotationPresent(Default.class)) {
                Object bean = ctx.getBean(o.getClass().getAnnotation(Default.class).value());
                //List<Field> ff = Arrays.stream(proxy.getClass().getDeclaredFields()).toList();
                Map<String, Method> methodMap = collectMethods(bean);

                for (Field f : fields) {
                    //System.out.println(ff.contains(f));
                    Method defaultMethod = methodMap.get(f.getName());
                    f.set(proxy, defaultMethod.invoke(bean, null));

                }

            } else {
                for (Field f : fields) {
                    String beanName = f.getAnnotation(Default.class).value();
                    Object defaultValue = ctx.getBean(beanName);
                    f.set(proxy, defaultValue);
                }
            }

            try {
                return m.invoke(o, args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private Map<String, Method> collectMethods(Object o) {
            return Arrays.stream(o.getClass().getDeclaredMethods())
                    .filter(m -> m.getName().startsWith("default") &&
                            fields.stream().anyMatch(f -> f.getName().equals(m.getName().substring(7).toLowerCase())))
                    .peek(m -> m.setAccessible(true))
                    .collect(Collectors.toMap(m -> m.getName().substring(7).toLowerCase(), Function.identity()));
        }
    }
}
