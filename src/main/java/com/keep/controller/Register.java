package com.keep.controller;

import com.keep.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
                    ("jdbc:mysql://localhost:3306/xkeep3","root","");
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