package ru.kornilaev.streamer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoubleOperator implements Action {
    @Override
    public List<String> apply(List<String> s) {
        return s.stream()
                .map(str -> str + str)
                .toList();
    }
}
