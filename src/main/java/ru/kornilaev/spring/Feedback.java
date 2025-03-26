package ru.kornilaev.spring;

public class Feedback implements Comparable<Feedback> {
    String text;
    int rating;

    public Feedback(String text, int rating) {
        this.text = text;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return text + ". Оценка: " + rating;
    }

    @Override
    public int compareTo(Feedback o) {
        return this.rating - o.rating;
    }
}
