package com.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
        String location = request.getParameter("location");
        int noOfParticipants = Integer.parseInt(request.getParameter("participants"));
        String organizer = request.getParameter("organizer");
        String organizerPhone = request.getParameter("organizerPhone");
        Date date = Date.valueOf(request.getParameter("date"));
        Time time = Time.valueOf(request.getParameter("time") + ":00");

        boolean isSuccess = EventDBUtil.insertEvent(name, location, noOfParticipants, organizer, organizerPhone, date, time);

        if (isSuccess) {
        	List<Event> allEvents = EventDBUtil.getAllEvents();
        	request.setAttribute("allEvents", allEvents);
        	RequestDispatcher dis = request.getRequestDispatcher("events.jsp");
			dis.forward(request, response);
        } else {
        	out.println("<script type='text/javascript'>");
			out.println("alert('Add Event Failed!');");
			out.println("location='login.jsp'");
			out.println("</script>");
        }
    }

}
