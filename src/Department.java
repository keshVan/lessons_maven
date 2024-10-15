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
        if(inDept(employee))
            throw new IllegalArgumentException("This employee already exists in this department");
        if (employee.getDept() != null) {
            throw new IllegalArgumentException("This employee work in another department");
        }
        employees.add(employee);
        employee.setDept(this);
    }

    public void removeEmployee(Employee employee){
        if(!inDept(employee))
            throw new IllegalArgumentException("This employee doesn't exist in this department");
        if (employee == head)
            head = null;
        employees.remove(employee);
        employee.setDept(null);
    }

    public String toString() {
        return "Работники: " + employees + " , начальник: " + head.getName();
    }

    private boolean inDept(Employee emp){
        return employees.contains(emp);
    }
}
