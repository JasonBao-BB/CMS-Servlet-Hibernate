package service;

import entity.Department;
import utility.JPAConnection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class DepartmentServiceImpl implements DepartmentService{
    @Override
    public List<Department> findAllDepartments() {
        EntityManager em = JPAConnection.getConnect();
        Query query = em.createQuery("select d from Department d");

        return query.getResultList();
    }

    @Override
    public Department findDepartmentById(Integer id) {
        EntityManager em = JPAConnection.getConnect();
        Department department = em.find(Department.class, id);
        return department;
    }

    @Override
    public void createDepartment(Department department) {
        EntityManager em = JPAConnection.getConnect();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        System.out.println("创建成功");
    }

    public static void main(String[] args) {
//        Department d1 = new Department("HR", "hr@company.com");
//        Department d2 = new Department("FINANCE", "finance@company.com");
//        Department d3 = new Department("INVESTMENT", "investment@company.com");
//        Department d4 = new Department("ADVERTISEMENT", "advertisement@company.com");
//
        DepartmentService departmentService = new DepartmentServiceImpl();

//        departmentService.createDepartment(d1);
//        departmentService.createDepartment(d2);
//        departmentService.createDepartment(d3);
//        departmentService.createDepartment(d4);

//        List<Department> departments = departmentService.findAllDepartments();
//        for (Department department : departments) {
//            System.out.println(department.getId()+" | "+department.getName() + " | " + department.getEmail());
//        }

        Department finance = departmentService.findDepartmentById(2);
        System.out.println(finance.getName());

    }
}
