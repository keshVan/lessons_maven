import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(23, 8);
        Point p3 = new Point(5, 10);
        Point p4 = new Point(25, 10);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        Line line3 = new Line(p1, p4);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        p1.x = 5;
        p1.y = 7;

        p4.x = 30;
        p4.y = 12;

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        Point p5 = new Point(31, 13);
        line1.start = p5;
        System.out.println(line1);
        System.out.println(line3);

        Name nm1 = new Name("Клеопатра");
        Name nm2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name nm3 = new Name("Маяковский", "Владимир");

        Human hm1 = new Human(nm1, 152);
        Human hm2 = new Human(nm2, 167);
        Human hm3 = new Human(nm3, 189);

        Name nm4 = new Name("Чудов", "Иван");
        Name nm5 = new Name("Чудов", "Петр");
        Name nm6 = new Name("Борис");

        Human ivan = new Human(nm4, 180);
        Human petr = new Human(nm5, 180, ivan, "m");
        Human boris = new Human(nm6, 180, petr, "m");

        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);

        Human elena = new Human(new Name("Елена"), 160, boris, "f");
        System.out.println(elena);

        Department itDept = new Department();
        itDept.name = "IT";

        Employee em1 = new Employee("Петров", itDept);
        Employee em2 = new Employee("Козлов", itDept);
        Employee em3 = new Employee("Сидоров", itDept);

        itDept.head = em2;

        System.out.println(em1);
        System.out.println(em2);
        System.out.println(em3);
    }
}