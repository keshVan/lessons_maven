public class Employee {
    String name;
    Department dept;

    public Employee(String name, Department dept) {
        this.name = name;
        this.dept = dept;
    }

    public String toString() {
        if (name == dept.head.name) {
            return name + " начальник " + dept.name + " отдела";
        }

        return name + " работает в отделе " + dept.name + ", начальник которого " + dept.head.name;
    }
}
