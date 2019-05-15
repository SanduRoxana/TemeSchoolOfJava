package repository;

import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertDepartment(Department department) {
        String query = "INSERT INTO department (id, name) VALUES (?, ?)";

        department.setId(getMaxId() + 1);

        jdbcTemplate.update(query, department.getId(), department.getName());

        System.out.println("Department added!");
    }

    public List<Department> selectAllDepartments() {
        String query = "SELECT * FROM department";

        return jdbcTemplate.query(query, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                Department department = new Department();
                department.setId(resultSet.getInt(1));
                department.setName(resultSet.getString(2));

                return department;
            }
        });
    }

    public void updateDepartment(Department department) {
        String query = "UPDATE department SET name = ? WHERE id = ?";

        if(existId(department.getId()).equals("Yes")) {
            jdbcTemplate.update(query, department.getName(), department.getId());
            System.out.println("Department with id = " + department.getId() + " updated!");
        } else {
            System.out.println("Department can't be updated! Department with id = " + department.getId() +
                    " doesn't exists in database!");
        }
    }

    public void deleteDepartment(Department department) {
        String query = "DELETE FROM department WHERE id = ?";

        if(existId(department.getId()).equals("Yes") && existDepartmentInEmployee(department.getId()).equals("No")) {
            jdbcTemplate.update(query, department.getId());
            System.out.println("Department with id = " + department.getId() + " deleted!");
        } else if (existDepartmentInEmployee(department.getId()).equals("Yes")) {
            System.out.println("Department can't be deleted! There are employees assigned to department with id = " +
                    department.getId() + "! Delete all employees, then delete department!");
        } else if(existId(department.getId()).equals("No")) {
            System.out.println("Department can't be deleted! Department with id = " + department.getId() +
                    " doesn't exists in database!");
        }
    }

    public int getMaxId() {
        int maxId;

        if(!getIdList().isEmpty()) {
            maxId = getIdList().get(0);
            for(int i = 1; i < getIdList().size(); i++) {
                if(getIdList().get(i) > maxId) {
                    maxId = getIdList().get(i);
                }
            }
        } else {
            maxId = 0;
        }

        return maxId;
    }

    public List<Integer> getIdList() {
        String query = "SELECT id FROM department";

        return jdbcTemplate.queryForList(query, Integer.class);
    }

    public String existId(int id) {
        String existId = "No";

        if(!getIdList().isEmpty()) {
            for(int i : getIdList()) {
                if(i == id) {
                    existId = "Yes";
                }
            }
        } else {
            existId = "No";
        }

        return existId;
    }

    public List<Integer> getDepartmentListFromEmployee() {
        String query = "SELECT department FROM employee";

        return jdbcTemplate.queryForList(query, Integer.class);
    }

    public String existDepartmentInEmployee(int id) {
        String contor = "No";
        for(int i : getDepartmentListFromEmployee()) {
            if(i == id) {
                contor = "Yes";
            }
        }

        return contor;
    }
}
