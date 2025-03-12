package ru.kornilaev.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.kornilaev.generics.Comparable;

public class Student implements Comparable<Student> {
    String name;
    List<Integer> marks = new ArrayList<>();
    Group group;

    List<UndoAction> historyActions = new ArrayList<>();

    public Student(String name, int... marks) {
        checkName(name);
        this.name = name;
        for (int mark : marks) {
            addMark(mark);
        }
        historyActions.add(new Create(name, marks));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
        historyActions.add(new ChangeName(this.name));
        this.name = name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<Integer>(marks);
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>();
        for (int mark : marks) {
            addMark(mark);
        }
        historyActions.add(new AddMark(marks.size()));
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        if (group != null) group.addStudent(this);
        this.group = group;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be null or empty");
    }

    public void addMark(int mark) throws IllegalMarkException {
        /*if (mark < 2 || mark > 5)
            throw new IllegalMarkException(mark);*/
        historyActions.add(new AddMark(1));
        marks.add(mark);
    }

    public void removeMark(int index) {
        marks.remove(index);
    }

    public String toString() {
        return name + ": " + marks;
    }

    public double getAverageMarks() {
        double res = 0;

        for (int mark : marks) {
            res += mark;
        }

        return res > 0 ? res / marks.size() : res;
    }

    public void undo() {
        historyActions.getLast().undo();
        historyActions.removeLast();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && getAverageMarks() == student.getAverageMarks();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAverageMarks());
    }

    public boolean isExcellent() {
        return this.getAverageMarks() == 5;
    }

    @Override
    public int compare(Student obj) {
        if (getAverageMarks() > obj.getAverageMarks()) return 1;
        if (getAverageMarks() < obj.getAverageMarks()) return -1;
        return 0;
    }

    private class ChangeName implements UndoAction {
        String oldName;

        public ChangeName(String oldName) {
            this.oldName = oldName;
        }

        @Override
        public void undo() {
            Student.this.name = oldName;
        }
    }

    private class Create implements UndoAction {
        String strartName;
        List<Integer> startMark = new ArrayList<>();

        public Create(String strartName, int... startMarks) {
            this.strartName = strartName;
            for (int mark : startMarks) {
                startMark.add(mark);
            }
        }

        @Override
        public void undo() {
            Student.this.name = strartName;
            Student.this.marks = startMark;
        }
    }

    private class AddMark implements UndoAction {
        int addedMarks;

        public AddMark(int addedMarks) {
            this.addedMarks = addedMarks;
        }

        @Override
        public void undo() {
            for (int i = 0; i < addedMarks; i++)
                marks.removeLast();
        }
    }

}
