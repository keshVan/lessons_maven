package ru.kornilaev.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class StudentFactory {
    private final Predicate<Integer> rule;

    @Autowired
    public StudentFactory(Predicate<Integer> range) {
        this.rule = range;
    }

    public Student newStudent(String name, int... marks) {
        return new Student(name, rule, marks);
    }
}
