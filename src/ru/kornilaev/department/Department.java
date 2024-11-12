package ru.kornilaev.department;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Employee head;
    private List<Employee> employees = new ArrayList<>();

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
        if (employee.getDept() != this)
            employee.setDept(this);
        if (!employees.contains(employee))
            employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        if (employee == null) return;
        if (!employees.contains(employee) && employee.getDept() != this) return;
        if (employee == head) head = null;
        if (employees.contains(employee) && employee.getDept() == this) {
            employees.remove(employee);
            employee.setDept(null);
        }
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
