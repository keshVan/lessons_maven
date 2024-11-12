package ru.kornilaev.department;

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
        if (this.dept == dept) return;
        if (this.dept != null) this.dept.removeEmployee(this);
        this.dept = dept;
        if (dept != null) dept.addEmployee(this);
    }

    public String toString() {
        if (this.dept != null) {
            if (this == dept.getHead()) {
                return name + " начальник " + " отдела";
            }

            return name + " работает в отделе " + dept.getName();
        }
        return name + " нигде не работает";
    }

}
