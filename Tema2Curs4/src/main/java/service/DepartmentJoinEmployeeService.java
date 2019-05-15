package service;

import model.DepartmentJoinEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import repository.DepartmentJoinEmployeeDao;

import java.util.List;

public class DepartmentJoinEmployeeService {

    @Autowired
    private DepartmentJoinEmployeeDao departmentJoinEmployeeDao;


    public void setDepartmentJoinEmployeeDao(DepartmentJoinEmployeeDao departmentJoinEmployeeDao) {
        this.departmentJoinEmployeeDao = departmentJoinEmployeeDao;
    }

    public List<DepartmentJoinEmployee> innerJoin() {
        if(departmentJoinEmployeeDao.innerJoin().isEmpty()) {
            System.out.println("Query INNER JOIN can't be executed! One or more tables are empty!");
        }
        return departmentJoinEmployeeDao.innerJoin();
    }

    public List<DepartmentJoinEmployee> leftJoin() {
        if(departmentJoinEmployeeDao.leftJoin().isEmpty()) {
            System.out.println("Query LEFT JOIN can't be executed! Tables are empty!");
        }

        return departmentJoinEmployeeDao.leftJoin();
    }

    public List<DepartmentJoinEmployee> rightJoin() {
        if(departmentJoinEmployeeDao.rightJoin().isEmpty()) {
            System.out.println("Query RIGHT JOIN can't be executed! One or more tables are empty!");
        }

        return departmentJoinEmployeeDao.rightJoin();
    }

    public List<DepartmentJoinEmployee> crossJoin() {
        if(departmentJoinEmployeeDao.crossJoin().isEmpty()) {
            System.out.println("Query CROSS JOIN can't be executed! One or more tables are empty!");
        }

        return departmentJoinEmployeeDao.crossJoin();
    }
}
