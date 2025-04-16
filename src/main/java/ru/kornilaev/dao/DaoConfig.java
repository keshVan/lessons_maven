package ru.kornilaev.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DaoConfig {
    @Bean
    public Connection connection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:mydb.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
