<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: clebe
  Date: 5/23/2021
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@ include file="header.jsp"%>
    </br>

    <%
        session = request.getSession(false);
        if( session.getAttribute("username") == null ) {
            response.sendRedirect("login.jsp");
        }
    %>

    <br/><br/><br/>
    <a href="<%=request.getContextPath()%>/newDepartment">Add New Department</a>
    <h2>Departments List</h2>
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
            <tr>
                <th>Department Id</th>
                <th>Department Name</th>
                <th>Department Location</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dept" items="${departments}">
                <tr>
                    <td><c:out value="${dept.deptId}"/></td>
                    <td><c:out value="${dept.deptName}"/></td>
                    <td><c:out value="${dept.deptLocation   }"/></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/deleteDepartment?dept=<c:out value="${dept.deptId}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
