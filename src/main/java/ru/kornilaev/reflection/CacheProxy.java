package ru.kornilaev.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class CacheProxy {

    private CacheProxy() {
    }

    public static <T> T cache(T obj) {
        if (obj == null || obj.getClass().isAnnotationPresent(Cache.class)) {
            return obj;
        } else {
            return (T) Proxy.newProxyInstance(
                    obj.getClass().getClassLoader(),
                    obj.getClass().getInterfaces(),
                    new ProxyHandler(obj)
            );
        }
    }

    private static class ProxyHandler implements InvocationHandler {
        final Object obj;
        final Map<MethodKey, Object> cacheMap = new HashMap<>();
        final Map<Field, Object> state = new HashMap<>();
        final Set<String> cachedMethods = new HashSet<>();

        ProxyHandler(Object obj) {
            this.obj = obj;

            Field[] fields = obj.getClass().getDeclaredFields();
            Arrays.stream(fields).forEach(f -> {
                try {
                    f.setAccessible(true);
                    state.put(f, f.get(obj));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });

            cachedMethods.addAll(List.of(obj.getClass().getAnnotation(Cache.class).value()));
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method = obj.getClass().getDeclaredMethod(method.getName(), getArgsClasses(args));
            method.setAccessible(true);

            if (!cachedMethods.contains(method.getName()) && cachedMethods.size() > 0)
                return method.invoke(this.obj, args);

            if (checkState()) cacheMap.clear();

            MethodKey mKey = new MethodKey(method, args);
            if (!cacheMap.containsKey(mKey)) {
                Object o = method.invoke(this.obj, args);
                cacheMap.put(mKey, o);
                return o;
            }
            return cacheMap.get(mKey);

        }

        private boolean checkState() {
            Field[] fields = obj.getClass().getDeclaredFields();
            boolean needClear = false;
            for (Field f : fields) {
                f.setAccessible(true);
                try {
                    Object value = f.get(obj);
                    if (!state.get(f).equals(value)) {
                        state.put(f, value);
                        needClear = true;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return needClear;
        }

        private boolean checkMethod(Method m, String[] cacheMethods) {
            for (String s : cacheMethods) {
                if (m.getName().equals(s)) return true;
            }
            return false;
        }

        private Class<?>[] getArgsClasses(Object[] args) {
            return args == null ? null : Arrays.stream(args)
                    .map(this::getPrimitiveClass)
                    .toList()
                    .toArray(Class<?>[]::new);
        }

        private Class<?> getPrimitiveClass(Object o) {
            Class<?> clazz = o.getClass();
            if (clazz == Integer.class) return int.class;
            if (clazz == Double.class) return double.class;
            if (clazz == Boolean.class) return boolean.class;
            if (clazz == Long.class) return long.class;
            if (clazz == Float.class) return float.class;
            if (clazz == Character.class) return char.class;
            if (clazz == Byte.class) return byte.class;
            if (clazz == Short.class) return short.class;

            return clazz;
        }
    }

    private static class MethodKey {
        final Method method;
        final List<Object> args;

        public MethodKey(Method m, Object[] args) {
            this.method = m;
            this.args = args == null ? null : Arrays.asList(args);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MethodKey mKey = (MethodKey) o;
            return method.equals(mKey.method) && Objects.equals(args, mKey.args);
        }

        @Override
        public int hashCode() {
            return Objects.hash(method, args);
        }
    }
}

