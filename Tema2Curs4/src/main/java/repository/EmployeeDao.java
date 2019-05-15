package repository;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertEmployee(Employee employee) {
        String query = "INSERT INTO employee (id, name, age, department) VALUES (?, ?, ?, ?)";

        if(existIdInDepartment(employee.getDepartment()).equals("Yes")) {
            employee.setId(getMaxId() + 1);
            jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getAge(), employee.getDepartment());
            System.out.println("Employee added!");
        } else {
            System.out.println("Employee can't be added! Department with id = " + employee.getDepartment() +
                    " doesn't exist in table Department! Add a department, then add an employee in that department!");
        }
    }

    public List<Employee> selectAllEmployees() {
        String query = "SELECT * FROM employee";

        return jdbcTemplate.query(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setAge(resultSet.getInt(3));
                employee.setDepartment(resultSet.getInt(4));

                return employee;
            }
        });
    }

    public void updateEmplyee(Employee employee) {
        String query = "UPDATE employee SET name = ?, age = ?, department = ? WHERE id = ?";

        if(existId(employee.getId()).equals("Yes") && existIdInDepartment(employee.getDepartment()).equals("Yes")) {
            jdbcTemplate.update(query, employee.getName(), employee.getAge(), employee.getDepartment(), employee.getId());
            System.out.println("Employee with id = "  + employee.getId() + " updated!");
        } else if(existId(employee.getId()).equals("No")) {
            System.out.println("Employee can't be updated! Employee with id = " + employee.getId() +
                    " doesn't exists in database!");
        } else if(existIdInDepartment(employee.getDepartment()).equals("No")) {
            System.out.println("Employee can't be updated! Department with id = " + employee.getDepartment() +
                    " doesn't exist in table Department! Add a department, then add an employee in that department!");
        }
    }

    public void deleteEmployee(Employee employee) {
        String query = "DELETE FROM employee WHERE id = ?";

        if(existId(employee.getId()).equals("Yes")) {
            jdbcTemplate.update(query, employee.getId());
            System.out.println("Employee with id = " + employee.getId() + " deleted!");
        } else {
            System.out.println("Employee can't be deleted! Employee with id = " + employee.getId() +
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
        String query = "SELECT id FROM employee";

        List<Integer> idList = jdbcTemplate.queryForList(query, Integer.class);

        return idList;
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

    public List<Integer> getIdListFromDepartment() {
        String query = "SELECT id FROM department";

        return jdbcTemplate.queryForList(query, Integer.class);
    }

    public String existIdInDepartment(int id) {
        String contor = "No";
        for(int i : getIdListFromDepartment()) {
            if(i == id) {
                contor = "Yes";
            }
        }

        return contor;
    }
}
