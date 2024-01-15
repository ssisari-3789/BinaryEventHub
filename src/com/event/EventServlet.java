package com.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//		
//        List<Event> allEvents = EventDBUtil.getAllEvents();
//        request.setAttribute("allEvents", allEvents);
//        
//        RequestDispatcher dis = request.getRequestDispatcher("events.jsp");
//		dis.forward(request, response);
//    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String searchQuery = request.getParameter("searchQuery");
	    
	    List<Event> filteredEvents;

	    if (searchQuery != null && !searchQuery.isEmpty()) {
	        // If a search query is provided, filter events based on it
	        filteredEvents = EventDBUtil.searchEventsByName(searchQuery);
	    } else {
	        // If no search query is provided, retrieve all events
	        filteredEvents = EventDBUtil.getAllEvents();
	    }

	    request.setAttribute("allEvents", filteredEvents);
	    
	    RequestDispatcher dis = request.getRequestDispatcher("events.jsp");
	    dis.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("delete".equals(action)) {
            String eventId = request.getParameter("eventId");
            boolean deleted = EventDBUtil.deleteEvent(eventId);
            
            if (deleted) {
                // Handle the deletion and return a success response (if needed)
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Handle deletion failure and return an error response (if needed)
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
        // Handle other actions or redirects as needed
    }
}
