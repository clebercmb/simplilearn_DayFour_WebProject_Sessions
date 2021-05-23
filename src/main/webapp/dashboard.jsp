<%--
  Created by IntelliJ IDEA.
  User: clebe
  Date: 5/23/2021
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Date" %>
<%@page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!--%@ page contentType="text/html;charset=UTF-8" language="java" %-->
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

    <%@ include file="header.jsp"%>
    <h2>Dashboard Page</h2>
    <%
        session = request.getSession(false);
        if( session.getAttribute("username") != null ) {
            out.println(session.getId());
            out.println("<br/><br/>");
            out.println("Session Creation Date: " + new Date(session.getCreationTime()) );
            out.println("<br/><br/>");
            out.println("Welcome " + session.getAttribute("username"));
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>
