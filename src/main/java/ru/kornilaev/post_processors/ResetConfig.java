package ru.kornilaev.post_processors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResetConfig {
    @Bean
    Integer defaultInt() {
        return 18;
    }
    @Bean
    String defaultString() {
        return "vasia";
    }
}
