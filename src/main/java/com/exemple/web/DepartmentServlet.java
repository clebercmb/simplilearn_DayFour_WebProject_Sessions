package com.exemple.web;

import com.models.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Department> departmentList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/trainingdb", "root", "mysql");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM departments");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
                Department department = new Department();
                department.setDeptId(rs.getInt(1));
                department.setDeptName(rs.getString(2));
                department.setDeptLocation(rs.getString(3));
                //System.out.println(department);

                departmentList.add(department);

            }
            System.out.println(departmentList);
            request.setAttribute("departments", departmentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("departments.jsp");
            dispatcher.forward(request,response);

            connection.close();
        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }
}
