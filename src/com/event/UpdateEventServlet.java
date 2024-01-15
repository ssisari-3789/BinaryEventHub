package com.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {       //update event
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String id = request.getParameter("eventId");
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		int participants = Integer.parseInt(request.getParameter("participants"));
		String organizer = request.getParameter("organizer");
		Date date = java.sql.Date.valueOf(request.getParameter("date"));
		Time time = java.sql.Time.valueOf(request.getParameter("time") + ":00");
		
		boolean isTrue;
		
		isTrue = EventDBUtil.updateEvent(id, name, location, participants, organizer, organizer, date, time);
		
		if(isTrue == true) {
			
			List<Event> eveDetails = EventDBUtil.getAllEvents();
			request.setAttribute("allEvents", eveDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("events.jsp");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
	}

}
