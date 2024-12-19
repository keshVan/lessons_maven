package ru.kornilaev.main;

import java.util.function.Function;

public class Transformator<T, P> {
    Reader<T> reader;

    Function<T, P> function;
    Writer<P> writer;

    public Transformator(Reader<T> reader, Function<T, P> function, Writer<P> writer) {
        this.reader = reader;
        this.function = function;
        this.writer = writer;
    }

    final void transform() {
        T read = reader.read();
        P transform = function.apply(read);
        writer.write(transform);
    }
}

interface Reader<T> {
    T read();
}


interface Writer<P> {
    void write(P obj);
}