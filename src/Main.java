import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
    }

    public static void addMark(Student[] stds, int x) {
        for (Student s : stds) {
            try {
                s.addMark(x);
            }
            catch (IllegalMarkException e) {
                for (Student std : stds) {
                    if (std == s) return;
                    std.removeMark(std.getMarks().size() - 1);
                }
            }
        }
    }
}