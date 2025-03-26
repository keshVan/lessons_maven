package ru.kornilaev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinMaxConfig {
    @Bean
    int min() {
        return 5;
    }

    @Bean
    int max() {
        return 10;
    }
}
