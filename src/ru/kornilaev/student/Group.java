package ru.kornilaev.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Iterable<Integer> {
    private String name;
    private int startYear;
    private int number;
    List<Student> students = new ArrayList<>();

    public Group(String name, int startYear, int number) {
        this.name = name;
        this.startYear = startYear;
        this.number = number;
    }

    public void addStudent(Student std) {
        if (std == null) return;
        if (students.contains(std) && std.group == this) return;
        if (std.group != null) std.group.removeStudent(std);
        students.add(std);
        std.group = this;
    }

    public void removeStudent(Student std) {
        if (std == null) return;
        if (std.group != this && !students.contains(std)) return;
        std.group = null;
        students.remove(std);
    }

    @Override
    public String toString() {
        return students.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MarksIterator();
    }

    private class MarksIterator implements Iterator<Integer> {
        int currStd = 0;
        int currMark = 0;

        @Override
        public boolean hasNext() {
            return currStd != students.size();
        }

        @Override
        public Integer next() {
            if (currMark == students.get(currStd).marks.size()) {
                currStd++;
                currMark = 0;
            }
            return students.get(currStd).marks.get(currMark++);
        }
    }
}
