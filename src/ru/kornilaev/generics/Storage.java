package ru.kornilaev.generics;

public class Storage<T> {
    final T value;
    final static Storage EMPTY_STORAGE = new Storage<>(null);

    private Storage(T object) {
        this.value = object;
    }

    public T getObject(T defaultValue) {
        if (value == null)
            return defaultValue;
        return value;
    }

    public static Storage empty() {
        return EMPTY_STORAGE;
    }

    public static <T> Storage<T> of(T el) {
        if (el == null) return empty();
        return new Storage<>(el);
    }
}
