package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if(userName.equals("cleber") && password.equals("12345")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
            response.sendRedirect("dashboard.jsp");

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request,response);

            out.println("<h3 style='color:red'>Invalid credentials. Please try again!</h3>");
        }

        out.close();
    }
}
