package ru.kornilaev.generics;

public class Box<T> {
    T object;

    public T get() {
        T tmp = object;
        object = null;
        return tmp;
    }

    public void set(T object) {
        if (this.object != null) throw new IllegalArgumentException("box isn't empty");
        this.object = object;
    }

    public boolean isEmpty() {
        return object == null;
    }
}
