package ru.kornilaev.generics;

public class Storage<T> {
    final T object, defaultValue;

    public Storage(T object, T defaultValue) {
        this.object = object;
        this.defaultValue = defaultValue;
    }

    public T getObject() {
        if (object == null)
            return defaultValue;
        return object;
    }
}
