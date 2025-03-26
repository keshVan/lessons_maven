package ru.kornilaev.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ru.kornilaev.student.Student;
import ru.kornilaev.student.StudentFactory;
import ru.kornilaev.weapons.Gunslinger;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class BeanConfig {
    @Bean
    String hello() {
        return "Hello World!";
    }

    @Bean
    int min() {
        return 5;
    }

    @Bean
    int max() {
        return 10;
    }

    @Bean
    @Scope("prototype")
    int random(@Qualifier("min") int min, @Qualifier("max") int max, @Qualifier("numbers") List<Integer> numbers) {
        Random rnd = new Random();
        if (numbers.isEmpty())
            fillNumbers(min, max, numbers);
        return numbers.remove(rnd.nextInt(numbers.size()));
    }

    @Bean
    List<Integer> numbers(@Qualifier("min") int min, @Qualifier("max") int max) {
        List<Integer> numbers = new ArrayList<>();
        fillNumbers(min, max, numbers);
        return numbers;
    }

    private void fillNumbers(int min, int max, List<Integer> num) {
        for (int i = min; i <= max; i++) {
            num.add(i);
        }
    }

    @Bean
    @Lazy
    Date date() {
        return new Date();
    }

    @Bean
    Predicate<Integer> range() {
        return (x) -> x >= 2 && x <= 5;
    }

    @Bean
    Feedback veryGood(@Qualifier("feedbacks") List<Feedback> feedback) {
        Feedback f = new Feedback("Очень хорошо", 4);
        feedback.add(f);
        return f;
    }

    @Bean
    Feedback good(@Qualifier("feedbacks") List<Feedback> feedback) {
        Feedback f = new Feedback("Хорошо", 3);
        feedback.add(f);
        return f;
    }

    @Bean
    @Scope("prototype")
    Feedback hardToSay(@Qualifier("random") int random, @Qualifier("feedbacks") List<Feedback> feedback) {
        Feedback f = new Feedback("Трудно сказать", random);
        feedback.add(f);
        return f;
    }

    @Bean
    @Scope("prototype")
    Feedback bestFeedback(@Qualifier("feedbacks") List<Feedback> feedbacks) {
        return feedbacks.stream()
                .max(Comparator.naturalOrder())
                .orElse(new Feedback("default", 0));
    }

    @Bean
    List<Feedback> feedbacks() {
        return new ArrayList<Feedback>();
    }

    @Bean
    Student std1(Predicate<Integer> range) {
        return new Student("петя", range, 2, 2, 4, 5);
    }

    @Bean
    Student std2(Predicate<Integer> range) {
        return new Student("вася", range, 5, 5, 5);
    }

    @Bean
    StudentFactory sf(Predicate<Integer> range) {
        return new StudentFactory(range);
    }
}
