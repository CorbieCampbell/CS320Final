/* CHARLES CAMPBELL
 * February 8, 2025
 * Appointment.java
 */

package Appointment;

import java.util.Date;

public class Appointment {
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDesc;
	
	// CONSTRUCTORS
	/*
	 * Constructor takes appointment ID, appointment date, and appointment description as parameters. 
	 * All parameters are checked if null or exceed a pre-determined limit. Appointment ID is truncated 
	 * to a maximum of 10 characters, date has to be before the current day, and description to 50 characters.
	 * 
	 */
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDesc) {
		/* Calls setter functions to validate each variable has appropriate requirements and gets set to constructor class */
		setAppointmentID(appointmentID);
			
		setAppointmentDate(appointmentDate);
		
		setAppointmentDesc(appointmentDesc);
	}
	
	

	/* GETTERS
	 * These functions are utilized for the AppointmentService class, for pulling appointment data
	 */
	
	// APPOINTMENT ID
	public String getAppointmentID() {
		return appointmentID;
	}
	
	// APPOINTMENT DATE
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	// APPOINTMENT DESCRIPTION
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	/* SETTERS
	 * These functions are utilized to check each variable meets specific requirements, before adding data to the constructor class,
	 * and is also used for the the AppointmentService functions, for updating contact data correctly
	 */
	
	// Special private setter for APPOINTMENT ID
	private void setAppointmentID(String appointmentID) {
		if(appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		else {
			this.appointmentID = appointmentID;
		}
	}
	
	// APPOINTMENT DATE
	public void setAppointmentDate(Date appointmentDate) {
		// .before(new Date()) ensures that the appointment date is before the current date & time
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
	}
	
	// APPOINTMENT DESCRIPTION
	public void setAppointmentDesc(String appointmentDesc) {
		if (appointmentDesc == null || appointmentDesc.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		else {
			this.appointmentDesc = appointmentDesc;
		}
	}
}