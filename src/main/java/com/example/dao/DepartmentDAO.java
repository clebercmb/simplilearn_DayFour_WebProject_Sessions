package com.example.dao;

import com.example.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    private String jdbcURL;
    private String jdbcUserName;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public DepartmentDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }

    void connect() throws SQLException {
        if(jdbcConnection == null  || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }

    public List<Department> getAllDepartments() {

        List<Department> departmentList = new ArrayList<>();
        try {

            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement("SELECT * FROM departments");
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

            jdbcConnection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departmentList;
    }

    public void insertDepartment(Department department) {
        System.out.println(department);
        try {

            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement("INSERT INTO departments(deptname,deptlocation) values (?,?)");
            statement.setString(1, department.getDeptName());
            statement.setString(2, department.getDeptLocation());
            int rows = statement.executeUpdate();
            if (rows > 1) {
                System.out.println("Department Inserted Successfully");
            } else {
                System.out.println("There is some error while inserting department");
            }
            jdbcConnection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDepartment(int id) {
        System.out.println("DepartmentDAO.deleteDepartment= " + id);
        try {

            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement("DELETE FROM  departments where deptId = (?)");
            statement.setInt(1,  id);
            int rows = statement.executeUpdate();
            jdbcConnection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
