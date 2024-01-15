package com.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet {              //customer insert
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String userName = request.getParameter("uid");
        String password = request.getParameter("psw");

        boolean isSuccess = CustomerDBUtil.insertcustomer(name, email, phone, userName, password);

        if (isSuccess) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Registration successful! You can now log in.');");
            out.println("location='login.jsp'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('Registration failed. Please try again.');");
            out.println("location='login.jsp'");
            out.println("</script>");
        }
		
	}

}
