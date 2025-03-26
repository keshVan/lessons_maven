package ru.kornilaev.streamer;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class FileSourceTarget implements DataSourceTarget {
    private String source;
    private String target;


    public void setSource(String source) {
        this.source = source;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public List<String> read() {
        try {
            return Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(List<String> data) {
        data.forEach(s -> {
                try {
                    Files.write(Path.of(target), s.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        });
    }
}
