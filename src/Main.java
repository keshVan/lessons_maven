import java.rmi.StubNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student vasya = new Student("Вася", 3, 4, 5);
        Student petya = new Student("Петя", vasya.marks);
        petya.marks[0] = 5;
        System.out.println(vasya);
        System.out.println(petya);
        Student andrey = new Student("Андрей", Arrays.copyOf(vasya.marks, vasya.marks.length));
        vasya.marks[0] = 2;
        System.out.println(vasya);
        System.out.println(andrey);
        System.out.println();

        Point p1 = new Point(1,5);
        Point p2 = new Point(2,8);
        Point p3 = new Point(5,3);

        BrokenLine bline1 = new BrokenLine(p1, p2, p3);
        System.out.println(bline1);

        Point p4 = new Point(2,-5);
        Point p5 = new Point(4,-8);

        BrokenLine bline2 = new BrokenLine(p1, p4, p5, p3);
        System.out.println(bline2);

        p1.x = 3;
        p1.y = 23;

        System.out.println(bline1);
        System.out.println(bline2);
        System.out.println();


        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        a.addLinkedCity(b, 1);
        a.addLinkedCity(d, 6);
        a.addLinkedCity(f, 5);

        b.addLinkedCity(a, 5);
        b.addLinkedCity(c, 3);

        c.addLinkedCity(b, 3);
        c.addLinkedCity(d, 4);

        d.addLinkedCity(a, 4);
        d.addLinkedCity(c, 2);
        d.addLinkedCity(e, 6);

        e.addLinkedCity(f, 2);

        f.addLinkedCity(b, 1);
        f.addLinkedCity(e, 2);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println();

        Department itDept = new Department("IT");
        Employee petrov = new Employee("Петров", itDept);
        Employee kozlov = new Employee("Козлов", itDept);
        Employee sidorov = new Employee("Сидоров", itDept);
        itDept.head = kozlov;
        Employee[] employees = {petrov, kozlov, sidorov};
        itDept.employees = employees;

        Employee[] employees1 = petrov.dept.getEmployees();
        for (Employee employee : employees1) {
            System.out.println(employee.name);
        }
    }
}