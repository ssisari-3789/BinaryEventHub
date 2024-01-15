package com.event;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.customer.DBConnect;


public class EventDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	
	public static List<Event> getEvent(String ename) {
		
		ArrayList<Event> event = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from events where name='"+ename+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				int noOfParticipants = rs.getInt(4);
				String organizer = rs.getString(5);
				String phone = rs.getString(6);
				Date date = rs.getDate(7);
				Time time = rs.getTime(8);
				
				Event gettingEvent = new Event(id,name,location, phone, noOfParticipants,organizer, date, time);
				event.add(gettingEvent);
			}
			
		} catch (Exception e) {
			
		}
		
		return event;	
	}
    
    public static boolean insertEvent(String name, String location, int noOfParticipants, String organizer, String phone, Date date, Time time) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "insert into events values (0,'"+name+"','"+location+"','"+noOfParticipants+"','"+organizer+"','"+phone+"','"+date+"','"+time+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
    
    public static boolean updateEvent(String id, String name, String location, int noOfParticipants, String organizer, String phone, Date date, Time time) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update events set name='"+name+"',location='"+location+"',noOfParticipants='"+noOfParticipants+"',organizer='"+organizer+"',organizerPhone='"+phone+"',date='"+date+"',time='"+time+"'"
    				+ "where id='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
    public static List<Event> getEventDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<Event> Ev = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from events where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {    			
    			int id = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				int noOfParticipants = rs.getInt(4);
				String organizer = rs.getString(5);
				String phone = rs.getString(6);
				Date date = rs.getDate(7);
				Time time = rs.getTime(8);
    			
    			Event e = new Event(id,name,location, phone, noOfParticipants,organizer, date, time);
    			Ev.add(e);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return Ev;	
    }
    
    public static List<Event> getAllEvents() {
        ArrayList<Event> events = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "select * from events";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String location = rs.getString(3);
                int noOfParticipants = rs.getInt(4);
                String organizer = rs.getString(5);
                String phone = rs.getString(6);
                Date date = rs.getDate(7);
                Time time = rs.getTime(8);

                Event event = new Event(id, name, location, phone, noOfParticipants, organizer, date, time);
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }
    
    
    public static boolean deleteEvent(String id) {
    	
    	int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from events where id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
     
    public static List<Event> searchEventsByName(String searchName) {
        ArrayList<Event> events = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "select * from events where name like '%" + searchName + "%'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String location = rs.getString(3);
                int noOfParticipants = rs.getInt(4);
                String organizer = rs.getString(5);
                String phone = rs.getString(6);
                Date date = rs.getDate(7);
                Time time = rs.getTime(8);

                Event event = new Event(id, name, location, phone, noOfParticipants, organizer, date, time);
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

}
