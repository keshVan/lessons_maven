package ru.kornilaev.department;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    Employee head;
    List<Employee> employees = new ArrayList<>();

    public Department(String name, Employee... emps){
        this.name = name;
        for (Employee emp : emps)
            addEmployee(emp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        if (head == null) return;
        if (this.head == head) return;
        if (!employees.contains(head) && head.getDept() != this)
            addEmployee(head);
        this.head = head;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = new ArrayList<>();
        for (Employee employee : employees)
            addEmployee(employee);
    }

    public void addEmployee(Employee employee){
        if (employee == null) return;
        if (employees.contains(employee) && employee.getDept() == this) return;
        employee.dept.removeEmployee(employee);
        employees.add(employee);
        employee.dept = this;
    }

    public void removeEmployee(Employee employee){
        if (employee == null) return;
        if (!employees.contains(employee) && employee.getDept() != this) return;
        if (employee == head) head = null;
        employees.remove(employee);
        employee.dept = null;
    }

    public String toString() {
        String headName = "";
        if (head != null)
            headName += head.getName();

        return "Работники: " + employees + " , начальник: " + headName;
    }

    private boolean inDept(Employee emp){
        return employees.contains(emp);
    }
}
