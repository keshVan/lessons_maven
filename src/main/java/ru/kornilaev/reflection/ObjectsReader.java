package ru.kornilaev.reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsReader<T> {
    private final String fileName;
    private final String PATH = "resources/";

    public ObjectsReader(String fileName) {
        this.fileName = fileName;
    }

    public List<T> read() throws IOException {
        List<T> objects = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] clsInfo = s.split(" ");
                Class<?> clazz = Class.forName(clsInfo[0]);
                Constructor<?>[] constructors = clazz.getDeclaredConstructors();
                Constructor<?> constructor = Arrays.stream(constructors)
                        .filter(c -> c.getParameterCount() == clsInfo.length - 1)
                        .findFirst()
                        .orElse(constructors[0]);

                Object[] args = new Object[clsInfo.length - 1];
                for (int i = 1; i < clsInfo.length; i++)
                    args[i - 1] = clsInfo[i];

                objects.add((T)constructor.newInstance(args));
            }
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
