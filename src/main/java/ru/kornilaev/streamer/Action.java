package ru.kornilaev.streamer;

import java.util.List;

public interface Action {
    List<String> apply(List<String> s);
}
