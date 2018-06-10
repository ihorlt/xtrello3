package com.keep.controller;

import com.mysql.fabric.jdbc.FabricMySQLConnectionProxy;
import com.mysql.jdbc.jdbc2.optional.ConnectionWrapper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.keep.view.IndexView;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indView = IndexView.getInstance();

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String role = request.getParameter("role");
        //int id = Integer.parseInt(number);
        try{

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection  con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/xtrello","root","17492911");
            PreparedStatement ps=con.prepareStatement
                    ("insert into user (username, password, name, status, role) values(?, ?, ?, ?,? )");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, status);
            ps.setString(5, role);
            int i=ps.executeUpdate();

            if(i>0)
            {
                indView.print(response, "Registered", indView.readHtmlFile("registered"));
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }

    }
}