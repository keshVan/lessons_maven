public class Department {
    String name;
    Employee head;
    Employee[] employees;

    public Department(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}
