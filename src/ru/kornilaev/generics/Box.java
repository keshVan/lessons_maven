package ru.kornilaev.generics;

public class Box<T> {
    T object;

    public T get() {
        if (isEmpty()) return null;
        T tmp = object;
        object = null;
        return tmp;
    }

    public void set(T object) {
        if (!isEmpty()) throw new IllegalArgumentException("box isn't empty");
        this.object = object;
    }

    public boolean isEmpty() {
        return object == null;
    }
}
