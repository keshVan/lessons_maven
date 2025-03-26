package ru.kornilaev.spring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyFileReader implements Reader {
    @Override
    public String read(String src) {
        try {
            return Files.readString(Path.of(src));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + src, e);
        }
    }
}
