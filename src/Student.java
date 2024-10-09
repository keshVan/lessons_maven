import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private  List<Integer> marks = new ArrayList<>();

    public Student(String name, int... marks) {
        checkName(name);
        this.name = name;
        for (int mark : marks)
            this.marks.add(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<Integer>(marks);
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    private void checkName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be null or empty");
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

    public boolean isExcellent() {
        return this.getAverageMarks() == 5;
    }
}
