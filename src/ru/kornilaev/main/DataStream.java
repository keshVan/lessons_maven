package ru.kornilaev.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DataStream<T> {

    List<T> collection;
    private DataStream(List<T> stream) {
        this.collection = List.copyOf(stream);
    }

    public static <P> DataStream<P> of(List<P> collection){
        return new DataStream<>(collection);
    }

    public <P> DataStream<P> map(Applier<T, P> a) {
        List<P> res = new ArrayList<>(collection.size());
        for (T el : collection)
            res.add(a.apply(el));
        return DataStream.of(res);
    }

    public DataStream<T> filter(Tester<T> a) {
        List<T> res = new ArrayList<>();
        for (T el : collection)
            if (a.test(el))
                res.add(el);
        return DataStream.of(res);
    }

    public T reduce(Reductor<T> a, T def) {
        if (collection.isEmpty()) return def;
        T res = collection.get(0);
        for (int i = 1; i < collection.size(); i++) {
            res = a.reduct(res, collection.get(i));
        }
        return res;
    }

    public <P> P collect(Supplier<P> s, Accumulator<P, T> a) {
        P outCollection = s.get();
        if (collection.isEmpty()) return outCollection;
        for (T el : collection) {
            a.accumulate(outCollection, el);
        }
        return outCollection;
    }
}

interface Applier<T, P> {
    P apply(T el);
}

interface Tester<T> {
    boolean test(T el);
}

interface Reductor<T> {
    T reduct(T res, T el);
}

interface Accumulator<T, P> {
    void accumulate(T collection, P element);
}
