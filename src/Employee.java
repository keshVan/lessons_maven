public class Employee {
    private String name;
    private Department dept;

    public Employee(String name, Department dept) {
        this.name = name;
        this.dept = dept;
    }

    public String toString() {
        if (this == dept.getHead()) {
            return name + " начальник " + dept.getName() + " отдела";
        }

        return name + " работает в отделе " + dept.getName() + ", начальник которого " + dept.getHead().name;
    }
}
