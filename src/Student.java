import java.util.Arrays;

public class Student {
    String name;
    int[] marks;

    public Student(String name, int... marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + ": " + Arrays.toString(marks);
    }

    public double getAverageMarks() {
        double res = 0;

        for (int i = 0; i < marks.length; i++) {
            res += marks[i];
        }

        return res > 0 ? res / marks.length : res;
    }

    public boolean isExcellentStudent() {
        return this.getAverageMarks() == 5;
    }
}
