package ru.kornilaev.spring;

import java.util.function.UnaryOperator;

public class DoubleFunction implements UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return s + s;
    }
}
