package model;

public class DepartmentJoinEmployee {
    private Department department;
    private Employee employee;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DepartmentJoinEmployee{" +
                "department=" + department +
                ", employee=" + employee +
                '}';
    }
}
