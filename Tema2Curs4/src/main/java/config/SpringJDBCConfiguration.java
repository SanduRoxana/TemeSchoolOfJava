package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repository.DepartmentDao;
import repository.DepartmentJoinEmployeeDao;
import repository.EmployeeDao;
import service.DepartmentJoinEmployeeService;
import service.DepartmentService;
import service.EmployeeService;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/database");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource());

        return jdbcTemplate;
    }

    @Bean
    public EmployeeDao employeeDao() {
        EmployeeDao employeeDao = new EmployeeDao();

        employeeDao.setJdbcTemplate(jdbcTemplate());

        return employeeDao;
    }

    @Bean
    public EmployeeService employeeService() {
        EmployeeService employeeService = new EmployeeService();

        employeeService.setEmployeeDao(employeeDao());

        return employeeService;
    }

    @Bean
    public DepartmentDao departmentDao() {
        DepartmentDao departmentDao = new DepartmentDao();

        departmentDao.setJdbcTemplate(jdbcTemplate());

        return departmentDao;
    }

    @Bean
    public DepartmentService departmentService() {
        DepartmentService departmentService = new DepartmentService();

        departmentService.setDepartmentDao(departmentDao());

        return departmentService;
    }

    @Bean
    public DepartmentJoinEmployeeDao departmentJoinEmployeeDao() {
        DepartmentJoinEmployeeDao departmentJoinEmployeeDao = new DepartmentJoinEmployeeDao();

        departmentJoinEmployeeDao.setJdbcTemplate(jdbcTemplate());

        return departmentJoinEmployeeDao;
    }

    @Bean
    public DepartmentJoinEmployeeService departmentJoinEmployeeService() {
        DepartmentJoinEmployeeService departmentJoinEmployeeService = new DepartmentJoinEmployeeService();

        departmentJoinEmployeeService.setDepartmentJoinEmployeeDao(departmentJoinEmployeeDao());

        return departmentJoinEmployeeService;
    }
}
