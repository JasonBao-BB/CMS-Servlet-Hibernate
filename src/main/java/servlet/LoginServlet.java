package servlet;

import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import utility.CheckAccount;
import utility.JPAConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean isMatched = CheckAccount.isMatch(email, password);

        req.getSession().setAttribute("userInfo", isMatched);

        if (isMatched) { //当我们登陆成功 1. 打印基本Info 2.显示所有的员工 3.显示所有的部门

            departmentService = new DepartmentServiceImpl();
            employeeService = new EmployeeServiceImpl();

            System.out.println("Login Success");

            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("employees", employeeService.findAllEmployees());
            req.getSession().setAttribute("departments", departmentService.findAllDepartments());

            req.getRequestDispatcher("/main.jsp").forward(req, resp);

        } else {
            System.out.println(email + " " + password);
            req.getSession().setAttribute("error", "User information not matched ! ");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            req.getSession().removeAttribute("error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
