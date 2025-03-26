package ru.kornilaev.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyFileWriter implements Writer {

    @Override
    public void write(String data, String dest) {
        try {
            Files.writeString(Path.of(dest), data);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + dest, e);
        }
    }
}
