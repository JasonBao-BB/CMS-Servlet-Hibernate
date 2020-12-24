package service;

import entity.Department;

import java.util.List;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/

public interface DepartmentService {

    List<Department> findAllDepartments();

    Department findDepartmentById(Integer id);

    void createDepartment(Department department);
}
