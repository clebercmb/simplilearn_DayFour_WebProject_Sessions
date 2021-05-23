package com.exemple.dao;

import com.models.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<Department> getAllDepartments() {

        List<Department> departmentList = new ArrayList<>();
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departmentList;
    }

}
