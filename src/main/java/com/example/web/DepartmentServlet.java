package com.example.web;

import com.example.dao.DepartmentDAO;
import com.example.models.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = "/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {

    DepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listDepartments(request, response);
        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        List<Department> departmentList = departmentDAO.getAllDepartments();

        System.out.println(departmentList);
        request.setAttribute("departments", departmentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("departments.jsp");
        dispatcher.forward(request, response);
    }
}
