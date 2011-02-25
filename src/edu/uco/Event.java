package edu.uco;

import java.util.Calendar;

import org.json.JSONObject;

public class Event {
	private JSONObject jObject;
	private String eventtitle; 
	private String eventdescription;
	private Calendar date;
	private double cost;
	private String sponsor;
	private String location;
	
	
//whatever	
	
	public String getEventtitle() {
		return eventtitle;
	}
	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}
	public void setjObject(JSONObject jObject) {
		this.jObject = jObject;
	}
	public JSONObject getjObject() {
		return jObject;
	}
	public void setjString(String jString) {
		this.eventtitle = jString;
	}
	public String getjString() {
		return eventtitle;
	}
	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}
	public String getEventdescription() {
		return eventdescription;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Calendar getDate() {
		return date;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCost() {
		return cost;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}

	} 
	