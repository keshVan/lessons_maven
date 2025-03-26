package ru.kornilaev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamerConfig {
    @Bean
    Streamer streamer() {
        return new Streamer();
    }
}
