package com.capgemini.ticket.reminder.automation.model;

import java.io.Serializable;
import java.util.Date;

public class DataOutputModel implements Serializable{
	
	private String incident_Number;
	private String resource_Name;
	private Date first_Reminder_Date;
	private Date second_Reminder_Date;
	private Date ticket_To_Be_Resolve_Date;
	private String comments;
	
	public String getIncident_Number() {
		return incident_Number;
	}
	public void setIncident_Number(String incident_Number) {
		this.incident_Number = incident_Number;
	}
	public String getResource_Name() {
		return resource_Name;
	}
	public void setResource_Name(String resource_Name) {
		this.resource_Name = resource_Name;
	}
	public Date getFirst_Reminder_Date() {
		return first_Reminder_Date;
	}
	public void setFirst_Reminder_Date(Date first_Reminder_Date) {
		this.first_Reminder_Date = first_Reminder_Date;
	}
	public Date getSecond_Reminder_Date() {
		return second_Reminder_Date;
	}
	public void setSecond_Reminder_Date(Date second_Reminder_Date) {
		this.second_Reminder_Date = second_Reminder_Date;
	}
	public Date getTicket_To_Be_Resolve_Date() {
		return ticket_To_Be_Resolve_Date;
	}
	public void setTicket_To_Be_Resolve_Date(Date ticket_To_Be_Resolve_Date) {
		this.ticket_To_Be_Resolve_Date = ticket_To_Be_Resolve_Date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public DataOutputModel(String incident_Number, String resource_Name, Date first_Reminder_Date,
			Date second_Reminder_Date, Date ticket_To_Be_Resolve_Date, String comments) {
		super();
		this.incident_Number = incident_Number;
		this.resource_Name = resource_Name;
		this.first_Reminder_Date = first_Reminder_Date;
		this.second_Reminder_Date = second_Reminder_Date;
		this.ticket_To_Be_Resolve_Date = ticket_To_Be_Resolve_Date;
		this.comments = comments;
	}
	public DataOutputModel() {
		super();
	}
	@Override
	public String toString() {
		return "DataOutputModel [incident_Number=" + incident_Number + ", resource_Name=" + resource_Name
				+ ", first_Reminder_Date=" + first_Reminder_Date + ", second_Reminder_Date=" + second_Reminder_Date
				+ ", ticket_To_Be_Resolve_Date=" + ticket_To_Be_Resolve_Date + ", comments=" + comments + "]";
	}

}
