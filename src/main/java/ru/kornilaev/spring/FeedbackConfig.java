package ru.kornilaev.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Configuration
public class FeedbackConfig {
    List<Feedback> feedbacks = new ArrayList<>();

    @Bean
    Feedback veryGood() {
        Feedback f = new Feedback("Очень хорошо", 4);
        feedbacks.add(f);
        return f;
    }

    @Bean
    Feedback good() {
        Feedback f = new Feedback("Хорошо", 3);
        feedbacks.add(f);
        return f;
    }

    @Bean
    @Scope("prototype")
    Feedback hardToSay(@Qualifier("random") int random) {
        Feedback f = new Feedback("Трудно сказать", random);
        feedbacks.add(f);
        return f;
    }

    @Bean
    @Scope("prototype")
    @Lazy
    Feedback bestFeedback() {
        return feedbacks.stream()
                .max(Comparator.naturalOrder())
                .orElse(new Feedback("default", 0));
    }
}
