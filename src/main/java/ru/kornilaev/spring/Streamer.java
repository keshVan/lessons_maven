package ru.kornilaev.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Streamer {
    private final Reader reader;
    private final Writer writer;
    private final List<UnaryOperator<String>> functions = new ArrayList<>();

    public Streamer(Reader reader, Writer writer, UnaryOperator<String>... functions) {
        this.reader = reader;
        this.writer = writer;
        this.functions.addAll(Arrays.asList(functions));
    }

    public void execute(String src, String dst) {
        String data = reader.read(src);
        for (var f : functions)
            data = f.apply(data);
        writer.write(data, dst);
    }
}