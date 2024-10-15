public class Employee {
    private String name;
    private Department dept;

    public Employee(String name, Department dept) {
        this.name = name;
        if (dept != null)
            dept.addEmployee(this);
        this.dept = dept;
    }

    public Employee(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept){
        if (this == dept.getHead())
            throw new IllegalArgumentException("This employee is head of " + dept.getName());
        this.dept = dept;
    }

    public String toString() {
        if (this == dept.getHead()) {
            return name + " начальник " + dept.getName() + " отдела";
        }

        return name + " работает в отделе " + dept.getName();
    }

}
