package ru.kornilaev.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DataStream<T> {
    private final List<T> collection;
    private final List<Command<?, ?>> commands;


    private DataStream(List<T> collection, List<Command<?, ?>> commands) {
        this.collection = collection;
        this.commands = commands;
    }

    public static <P> DataStream<P> of(List<P> collection) {
        return new DataStream<>(collection, new ArrayList<>());
    }

    public <P> DataStream<T> map(Applier<T, P> a) {
        List<Command<?, ?>> newCommands = new ArrayList<>(commands);
        newCommands.add(new Map<>(a));
        return new DataStream<>(collection, newCommands);
    }

    public DataStream<T> filter(Tester<T> t) {
        List<Command<?, ?>> newCommands = new ArrayList<>(commands);
        newCommands.add(new Filter<>(t));
        return new DataStream<>(collection, newCommands);
    }

    public T reduce(Reductor<T> reductor, T def) {
        List<T> list = executeCommands();
        T result = def;
        for (T el : list) {
            result = reductor.reduct(result, el);
        }
        return result;
    }

    public <P> P collect(Supplier<P> supplier, Accumulator<P, T> accumulator) {
        List<T> list = executeCommands();
        P result = supplier.get();
        for (T el : list) {
            accumulator.accumulate(result, el);
        }
        return result;
    }

    private interface Command<T, P> {
        P execute(T el);
    }


    private List<T> executeCommands() {
        List<T> res = new ArrayList<>(collection);
        for (Command c :  commands) {
            for (int i  = 0; i < res.size(); i++) {
                Object before = res.get(i);
                Object after = c.execute(before);
                if (after != null) res.set(i, (T)after);
                if (after == null && res.contains(before)) res.remove(i);
            }
        }
        return res;
    }

    private static class Map<T, P> implements Command<T, P> {
        private final Applier<T, P> applier;

        public Map(Applier<T, P> applier) {
            this.applier = applier;
        }

        @Override
        public P execute(T el) {
            return applier.apply(el);
        }
    }

    private static class Filter<T> implements Command<T, T> {
        private final Tester<T> tester;

        public Filter(Tester<T> tester) {
            this.tester = tester;
        }

        @Override
        public T execute(T el) {
            return tester.test(el) ? el : null;
        }
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


