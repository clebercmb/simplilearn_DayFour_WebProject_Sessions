<%--
  Created by IntelliJ IDEA.
  User: clebe
  Date: 5/29/2021
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <form action="<%=request.getContextPath()%>/insertDepartment">
    <input type="text" name="deptName" placeholder="Department Name"/>
    <input type="text" name="deptLocation" placeholder="Department Location"/>
    <input type="submit"/>
  </form>

</body>
</html>
