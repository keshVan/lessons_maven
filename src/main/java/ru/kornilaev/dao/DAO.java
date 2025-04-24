package ru.kornilaev.dao;

import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;

@Component
public class DAO {
    private final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public <T> List<T> findAll(Class<T> clazz) {
        List<T> result = new ArrayList<>();
        String table = clazz.getSimpleName().toLowerCase() + "s";

        Map<String, Field> columnMap = new HashMap<>();
        Map<String, Method> setterMap = new HashMap<>();

        for (Field f : clazz.getDeclaredFields()) {
            String column = f.getName();
            if (f.isAnnotationPresent(Column.class))
                column = f.getAnnotation(Column.class).value();

            columnMap.put(column, f);

            String setterName = "set" + Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
            try {
                Method setter = clazz.getDeclaredMethod(setterName, f.getType());
                setterMap.put(column, setter);
            } catch (NoSuchMethodException _) {
                f.setAccessible(true);
            }
        }

        String columns = String.join(", ", columnMap.keySet());
        String sql = "SELECT " + columns + " FROM " + table;

        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                T obj = clazz.getDeclaredConstructor().newInstance();

                for (Map.Entry<String, Field> entry : columnMap.entrySet()) {
                    String column = entry.getKey();

                    Object val = rs.getObject(column);

                    if (setterMap.containsKey(column)) {
                        setterMap.get(column).invoke(obj, val);
                    } else {
                        entry.getValue().set(obj, val);
                    }
                }

                result.add(obj);
            }
        } catch (SQLException | ReflectiveOperationException e) {
            throw new DaoException("Failed to set data for class: " + clazz.getSimpleName(), e);
        }

        return result;
    }
}
