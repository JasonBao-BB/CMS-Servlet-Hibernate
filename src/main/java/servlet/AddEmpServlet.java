package servlet;

import entity.Department;
import entity.Employee;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addEmp")
public class AddEmpServlet extends HttpServlet {

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        departmentService = new DepartmentServiceImpl();
        employeeService = new EmployeeServiceImpl();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        Integer department = Integer.parseInt(req.getParameter("department"));

        Department dept = departmentService.findDepartmentById(department);
        Employee emp = new Employee(firstName, lastName, salary);
        emp.setDepartment(dept);

        employeeService.createEmployee(emp);

        System.out.println("Create Success");

        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
