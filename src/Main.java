import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student std = new Student("Вася", 1, 2, 3);
        List<Integer> marks = std.getMarks();
        marks.add(11);
        System.out.println(marks);
        System.out.println(std);
    }
}