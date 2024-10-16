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
        if (!inDept(head))
            throw new IllegalArgumentException("Head of the department must work in it");
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
        
    }

    public String toString() {
        return "Работники: " + employees + " , начальник: " + head.getName();
    }

    private boolean inDept(Employee emp){
        return employees.contains(emp);
    }
}
