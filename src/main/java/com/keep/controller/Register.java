package com.keep.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String number = request.getParameter("id");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String role = request.getParameter("role");
        int id = Integer.parseInt(number);
        try{

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection  con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/xtrello","root","17492911");

            PreparedStatement ps=con.prepareStatement
                    ("insert into user values(?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, name);
            ps.setString(5, status);
            ps.setString(6, role);
            int i=ps.executeUpdate();

            if(i>0)
            {
                out.println("You are sucessfully registered");
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }

    }
}