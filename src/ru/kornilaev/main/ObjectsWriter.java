package ru.kornilaev.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ObjectsWriter {
    private final String fileName;
    private final String PATH = "resources/";

    public ObjectsWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(List<?> objects) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + fileName))){
            for (Object o : objects) {
                Class<?> clazz = o.getClass();

                StringBuilder sb = new StringBuilder(clazz.getName()).append(" ");
                Arrays.stream(clazz.getDeclaredFields())
                                .forEach(f -> {
                                    f.setAccessible(true);
                                    try {
                                        sb.append(f.get(o)).append(" ");
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    }
                                });

                writer.write(sb.substring(0, sb.length() - 1));
                writer.newLine();
            }
        }
    }
}
