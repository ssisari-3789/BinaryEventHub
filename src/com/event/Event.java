package com.event;

import java.sql.Date;
import java.sql.Time;

public class Event {             //create event class
	private int id;
    private String name;
    private String location;
    private String organizerPhone;
    private int noOfParticipants;
    private String organizer;
    private Date date;
    private Time time;
    
	public Event(int id, String name, String location, String organizerPhone, int noOfParticipants, String organizer,
			Date date, Time time) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.organizerPhone = organizerPhone;
		this.noOfParticipants = noOfParticipants;
		this.organizer = organizer;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrganizerPhone() {
		return organizerPhone;
	}

	public void setOrganizerPhone(String organizerPhone) {
		this.organizerPhone = organizerPhone;
	}

	public int getNoOfParticipants() {
		return noOfParticipants;
	}

	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
