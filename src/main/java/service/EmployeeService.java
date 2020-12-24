package service;

import entity.Department;
import entity.Employee;

import java.util.List;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
public interface EmployeeService {
    List<Employee> findAllEmployees();

    void createEmployee(Employee employee);
}
