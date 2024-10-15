import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Department dept = new Department("IT");
        Employee emp1 = new Employee("Artem", dept);
        Employee emp2 = new Employee("Ivan", dept);
        Employee emp3 = new Employee("Petr", dept);
        Employee emp4 = new Employee("Jopa");

        Department dept2 = new Department("Security", emp4);
        dept.setHead(emp1);
        dept2.setHead(emp4);
        dept.addEmployee(emp4);
        System.out.println(dept2);

        System.out.println(dept);

    }
}