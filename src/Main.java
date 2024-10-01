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


        City city1 = new City("A");
        City city2 = new City("B");
        City city3 = new City("C");
        City city4 = new City("D");
        City city5 = new City("E");
        City city6 = new City("F");

        city1.addLinkedCity(city2, 1);
        city1.addLinkedCity(city4, 6);
        city1.addLinkedCity(city6, 5);

        city2.addLinkedCity(city1, 5);
        city2.addLinkedCity(city3, 3);

        city3.addLinkedCity(city2, 3);
        city3.addLinkedCity(city4, 4);

        city4.addLinkedCity(city1, 4);
        city4.addLinkedCity(city3, 2);
        city4.addLinkedCity(city5, 6);

        city5.addLinkedCity(city6, 2);

        city6.addLinkedCity(city2, 1);
        city6.addLinkedCity(city5, 2);

        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);
        System.out.println(city4);
        System.out.println(city5);
        System.out.println(city6);
        System.out.println();

        Department itDept = new Department("IT");
        Employee emp1 = new Employee("Петров", itDept);
        Employee emp2 = new Employee("Козлов", itDept);
        Employee emp3 = new Employee("Сидоров", itDept);
        itDept.head = emp2;
        Employee[] employees = {emp1, emp2, emp3};
        itDept.employees = employees;

        Employee[] employees1 = emp1.dept.getEmployees();
        for (Employee employee : employees1) {
            System.out.println(employee.name);
        }
    }
}