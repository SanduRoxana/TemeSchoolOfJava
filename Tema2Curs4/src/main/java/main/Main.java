package main;

import config.SpringJDBCConfiguration;
import model.Department;
import model.DepartmentJoinEmployee;
import model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.DepartmentJoinEmployeeService;
import service.DepartmentService;
import service.EmployeeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringJDBCConfiguration.class);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        DepartmentJoinEmployeeService departmentJoinEmployeeService =
                context.getBean(DepartmentJoinEmployeeService.class);

//        --- Insert Department ---
//        departmentService.insert("Marketing");

//        --- Select All Departments ---
//        List<Department> departmentList = departmentService.selectAll();
//
//        for(Department department : departmentList) {
//            System.out.println(department);
//        }

//        --- Update Department ---
//        departmentService.update(1, "MarketingUpdated");

//        --- Delete Department ---
//        departmentService.delete(1);

//        --- Insert Employee ---
//        employeeService.insert("Ion", 45, 1);

//        --- Select All Employees ---
//        List<Employee> employeeList = employeeService.selectAll();
//
//        for(Employee employee : employeeList) {
//            System.out.println(employee);
//        }

//        --- Update Employee ---
//        employeeService.update(1, "IonUpdated", 56, 1);

//        --- Delete Employee ---
//        employeeService.delete(1);

//        --- Department Inner Join Employee ---
//        List<DepartmentJoinEmployee> list1 = departmentJoinEmployeeService.innerJoin();
//
//        for(DepartmentJoinEmployee departmentJoinEmployee : list1) {
//            System.out.println(departmentJoinEmployee);
//        }

//        --- Department Left Join Employee ---
//        List<DepartmentJoinEmployee> list2 = departmentJoinEmployeeService.leftJoin();
//
//        for(DepartmentJoinEmployee departmentJoinEmployee : list2) {
//            System.out.println(departmentJoinEmployee);
//        }

//        --- Department Right Join Employee ---
//        List<DepartmentJoinEmployee> list3 = departmentJoinEmployeeService.rightJoin();
//
//        for(DepartmentJoinEmployee departmentJoinEmployee : list3) {
//            System.out.println(departmentJoinEmployee);
//        }

//        --- Department Cross Join Employee ---
//        List<DepartmentJoinEmployee> list4 = departmentJoinEmployeeService.crossJoin();
//
//        for(DepartmentJoinEmployee departmentJoinEmployee : list4) {
//            System.out.println(departmentJoinEmployee);
//        }

    }
}
