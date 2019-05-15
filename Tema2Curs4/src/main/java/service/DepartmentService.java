package service;

import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DepartmentDao;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void insert(String name) {
        if(!name.equals("")) {
            Department department = new Department();
            department.setName(name);
            departmentDao.insertDepartment(department);
        } else {
            System.out.println("Department wasn't added! Input data doesn't match!");
        }
    }

    public List<Department> selectAll() {
        if(departmentDao.selectAllDepartments().isEmpty()) {
            System.out.println("Table Department is empty!");
        }

        return departmentDao.selectAllDepartments();
    }

    public void update(int id, String name) {
        if(id > 0 && (!name.equals(""))) {
            Department department = new Department(id, name);
            departmentDao.updateDepartment(department);
        } else {
            System.out.println("Department wasn't updated! Input data doesn't match!");
        }
    }

    public void delete(int id) {
        if(id > 0) {
            Department department = new Department();
            department.setId(id);
            departmentDao.deleteDepartment(department);
        } else {
            System.out.println("Department wasn't deleted! Input data doesn't match!");
        }
    }
}
