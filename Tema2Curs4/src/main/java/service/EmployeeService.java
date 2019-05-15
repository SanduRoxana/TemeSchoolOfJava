package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeDao;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void insert(String name, int age, int department) {
        if((!name.equals("")) && age > 0 && department > 0) {
            Employee employee = new Employee();
            employee.setName(name);
            employee.setAge(age);
            employee.setDepartment(department);
            employeeDao.insertEmployee(employee);
        } else {
            System.out.println("Employee wasn't added! Input data doesn't match!");
        }
    }

    public List<Employee> selectAll() {
        if(employeeDao.selectAllEmployees().isEmpty()) {
            System.out.println("Table Employee is empty!");
        }

        return employeeDao.selectAllEmployees();
    }

    public void update(int id, String name, int age, int department) {
        if(id > 0 && (!name.equals("")) && age > 0 && department > 0) {
            Employee employee = new Employee(id, name, age, department);
            employeeDao.updateEmplyee(employee);
        } else {
            System.out.println("Employee wasn't updated! Input data doesn't match!");
        }
    }

    public void delete(int id) {
        if(id > 0) {
            Employee employee = new Employee();
            employee.setId(id);
            employeeDao.deleteEmployee(employee);
        } else {
            System.out.println("Employee wasn't deleted! Input data doesn't match!");
        }
    }
}
