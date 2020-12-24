package service;

import entity.Department;
import entity.Employee;
import utility.JPAConnection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> findAllEmployees() {
        EntityManager em = JPAConnection.getConnect();
        Query query = em.createQuery("select e from Employee e");

        return query.getResultList();
    }

    @Override
    public void createEmployee(Employee employee) {
        EntityManager em = JPAConnection.getConnect();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        System.out.println("创建成功");
    }

    //Test
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();

        Department hr = departmentService.findDepartmentById(1);
        Department finance = departmentService.findDepartmentById(2);
        Department advertisement = departmentService.findDepartmentById(4);

        Employee e1 = new Employee("Jack","Li", 20000);
        e1.setDepartment(hr);

        Employee e2 = new Employee("Bruce","Helon", 5000);
        e2.setDepartment(advertisement);

        Employee e3 = new Employee("Ymir","Yent", 8000);
        e3.setDepartment(hr);

        Employee e4 = new Employee("Jason","Bao", 1000000);
        e4.setDepartment(finance);
        Employee e5 = new Employee("Alex","Sion", 450000);
        e5.setDepartment(finance);

        employeeService.createEmployee(e1);
        employeeService.createEmployee(e2);
        employeeService.createEmployee(e3);
        employeeService.createEmployee(e4);
        employeeService.createEmployee(e5);

        List<Employee> employees = employeeService.findAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.getId()+" | "+employee.getFirstName()
                    + " | " + employee.getLastName()+ " | " + employee.getSalary());

        }
    }
}
