<%--
  Created by IntelliJ IDEA.
  User: boyangbao
  Date: 12/23/20
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <title>Main Page</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty userInfo and userInfo}">
            <h1>Welcome, ${sessionScope.email}</h1>

            <table align="center" border="1">
                <h4>Employee Table</h4>
                <tr>
                    <td>ID</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Salary</td>
                </tr>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.id}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.salary}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td><a href="addEmployee.jsp">Add New Employee</a></td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <h1>Please Login First</h1>
            <a href="index.jsp"> Log In </a>
        </c:otherwise>
    </c:choose>


</body>
</html>
