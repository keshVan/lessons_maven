package ru.kornilaev.streamer;

import java.util.List;

public interface DataSourceTarget {
    List<String> read();
    void write(List<String> data);
}
