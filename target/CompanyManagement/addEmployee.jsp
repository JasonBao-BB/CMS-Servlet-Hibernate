<%--
  Created by IntelliJ IDEA.
  User: boyangbao
  Date: 12/23/20
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <title>Employee</title>
</head>
<body>
    <c:choose>
    <c:when test="${not empty userInfo and userInfo}">
        <h1>Welcome, ${sessionScope.email}</h1>

        <form action="/addEmp" method="post">
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" required="required"></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" required="required"></td>
                </tr>
                <tr>
                    <td>Salary:</td>
                    <td><input type="text" name="salary" required="required"></td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td>
                        <select name="department" required="required">
                            <option value="">Please Select Department</option>
                            <c:forEach var="department" items="${sessionScope.departments}">
                                <option value="${department.id}">${department.name} - ${department.email}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit">
                        <a href="/main.jsp">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </c:when>
    <c:otherwise>
        <h1 align="center">Please Login First</h1>
        <a href="index.jsp"> Log In </a>
    </c:otherwise>
</c:choose>
</body>
</html>
