package ru.kornilaev.student;

import java.util.function.Predicate;

public class StudentFactory {
    private final Predicate<Integer> rule;

    public StudentFactory(Predicate<Integer> rule) {
        this.rule = rule;
    }

    public Student newStudent(String name, int... marks) {
        return new Student(name, rule, marks);
    }
}
