package ru.kornilaev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Configuration
public class RandomConfig {
    @Autowired
    private int min;
    @Autowired
    private int max;
    private List<Integer> numbers = new ArrayList<>();
    private Random random = new Random();

    @Bean
    @Scope("prototype")
    public int random() {
        if (numbers.isEmpty()) {
            for (int i = min; i <= max; i++) {
                numbers.add(i);
            }
        }

        return numbers.remove(random.nextInt(numbers.size()));
    }
}
