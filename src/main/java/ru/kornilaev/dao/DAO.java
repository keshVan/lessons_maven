package ru.kornilaev.dao;

import org.springframework.stereotype.Component;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class DAO {
    private final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public <T> List<T> findAll(Class<T> clazz) throws SQLException, NoSuchMethodException {
        List<T> result = new ArrayList<>();
        String table = clazz.getSimpleName().toLowerCase() + "s";

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM " + table);
        ResultSetMetaData md = rs.getMetaData();

        Constructor<T> constructor = (Constructor<T>) clazz.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        Map<String, Integer> argsPos = getArgsPos(constructor);

        while (rs.next()) {
            T obj = null;
            Object[] args = new Object[md.getColumnCount()];

            for (int i = 1; i <= md.getColumnCount(); i++) {
                String column  = md.getColumnName(i);
                Object val = rs.getObject(i);
                args[argsPos.get(column)] = val;
                try {
                    obj = constructor.newInstance(args);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            result.add(obj);
        }
        return result;
    }

    private Map<String, Integer> getArgsPos(Constructor<?> constructor) {
        Map<String, Integer> res = new LinkedHashMap<>();
        Parameter[] parameters = constructor.getParameters();
        int pos = 0;
        for (Parameter p : parameters) {
            String fieldName = p.getAnnotation(FieldName.class).value();
            res.put(fieldName, pos);
            pos++;
        }
        return res;
    }
}
