package com.example.web;

import com.example.dao.DepartmentDAO;
import com.example.models.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = {"/DepartmentServlet", "/newDepartment", "/insertDepartment", "/deleteDepartment", "/listDepartment"})
public class DepartmentServlet extends HttpServlet {


    DepartmentDAO departmentDAO;

    @Override
    public void init() throws ServletException {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        departmentDAO = new DepartmentDAO(jdbcURL, jdbcUserName, jdbcPassword);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String action = request.getServletPath();

            switch (action) {
                case "/newDepartment":
                    newDepartmentForm(request, response);
                    break;
                case "/insertDepartment":
                    insertDepartment(request, response);
                    break;
                case "/deleteDepartment":
                    deleteDepartment(request,response);
                    break;
              default:
                    listDepartments(request, response);
                    break;

            }

        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Deleting department here");
        PrintWriter out = response.getWriter();
        out.println("Deleting department here");
        int id = Integer.parseInt(request.getParameter("deptId"));

    }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //PrintWriter out = response.getWriter();
        //out.println("Inserting new Department here");
        System.out.println(">>insertDepartment");
        Department department = new Department();
        department.setDeptName(request.getParameter("deptName"));
        department.setDeptLocation(request.getParameter("deptLocation"));
        departmentDAO.insertDepartment(department);
        response.sendRedirect("listDepartment");
    }

    private void newDepartmentForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("Display Form here");

        RequestDispatcher dispatcher = request.getRequestDispatcher("newDepartmentForm.jsp");
        dispatcher.forward(request, response);

    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        List<Department> departmentList = departmentDAO.getAllDepartments();

        System.out.println(departmentList);
        request.setAttribute("departments", departmentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("departments.jsp");
        dispatcher.forward(request, response);
    }
}
