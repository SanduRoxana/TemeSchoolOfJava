package repository;

import model.Department;
import model.DepartmentJoinEmployee;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentJoinEmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DepartmentJoinEmployee> innerJoin() {
        String query = "SELECT * FROM department INNER JOIN employee ON employee.department = department.id";

        return jdbcTemplate.query(query, new DepartmentJoinEmployeeRowMapper());
    }

    public List<DepartmentJoinEmployee> leftJoin() {
        String query = "SELECT * FROM department LEFT JOIN employee ON employee.department = department.id";

        return jdbcTemplate.query(query, new DepartmentJoinEmployeeRowMapper());
    }

    public List<DepartmentJoinEmployee> rightJoin() {
        String query = "SELECT * FROM department RIGHT JOIN employee ON employee.department = department.id";

        return jdbcTemplate.query(query, new DepartmentJoinEmployeeRowMapper());
    }

    public List<DepartmentJoinEmployee> crossJoin() {
        String query = "SELECT * FROM department CROSS JOIN employee";

        return jdbcTemplate.query(query, new DepartmentJoinEmployeeRowMapper());
    }

    protected class DepartmentJoinEmployeeRowMapper implements RowMapper<DepartmentJoinEmployee> {
        @Override
        public DepartmentJoinEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));

            Employee employee = new Employee();
            employee.setId(resultSet.getInt(3));
            employee.setName(resultSet.getString(4));
            employee.setAge(resultSet.getInt(5));
            employee.setDepartment(resultSet.getInt(6));

            DepartmentJoinEmployee departmentJoinEmployee = new DepartmentJoinEmployee();
            departmentJoinEmployee.setDepartment(department);
            departmentJoinEmployee.setEmployee(employee);

            return departmentJoinEmployee;
        }
    }
}
