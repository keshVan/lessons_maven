package ru.kornilaev.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class StudentConfig {
    @Bean
    Student std1(Predicate<Integer> range) {
        return new Student("петя", range, 2, 2, 4, 5);
    }

    @Bean
    Student std2(Predicate<Integer> range) {
        return new Student("вася", range, 5, 5, 5);
    }
}
