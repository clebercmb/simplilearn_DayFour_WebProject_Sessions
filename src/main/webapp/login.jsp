<%--
  Created by IntelliJ IDEA.
  User: clebe
  Date: 5/23/2021
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@ include file="header.jsp"%>
    <h2>Login Page</h2>
    <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Enter Username"/>
        <input type="password" name="password" placeholder="Enter Password"/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
