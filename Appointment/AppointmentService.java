/* CHARLES CAMPBELL
 * February 8, 2025
 * AppointmentService.java
 */

package Appointment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AppointmentService {
		// Necessary function to ensure that the appointment service only has one instance (helps make sure program is thread safe)
		private static AppointmentService INSTANCE;
		
		// Construction of the service (private ensures that only this instance can only create itself)
		private AppointmentService() {}
		
		// Synchronized (single thread) of creation of the instance; checks if there is no instance and then creates it
		public static synchronized AppointmentService getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new AppointmentService();
			}
			return INSTANCE;
		}
		
		// Creation of appointment hash map to hold the objects
		Map<String, Appointment> appointmentMap = new ConcurrentHashMap<>();
			
		/**
		 * ADDS an appointment at the ID number
		 * @param appointment
		 */
		public boolean addAppointment(Appointment appointment) {
			// Method putIfAbset checks the HashMap if the index is filled or not
			// and will fill the bucket with the object if the bucket is NULL,
			// or returns a false if bucket is already filled
			return appointmentMap.putIfAbsent(appointment.getAppointmentID(), appointment) == null;
		}
		
		/**
		 * DELETES the appointment at the index ID
		 * if the indicated index isn't null
		 * @param appointmentID
		 */	
		public boolean deleteAppointment(String appointmentID) {
			return appointmentMap.remove(appointmentID) != null;
		}
		
		/**
		 * Edits the Date of the Appointment Object at appointmentID
		 * Uses the setAppointmentDate method
		 * @param appointmentID
		 * @param appointmentDate
		 */
		public boolean editAppointmentDate(String appointmentID, Appointment updated) {
			// Pulls the current contact in the map with the ID
			Appointment existing = (appointmentMap.get(appointmentID));
			// If the contact is not in the map, return false
			if (existing == null) return false;
			// With the contact in the map, get the updated first name and set it to the existing contact in the database
			// then return true
			existing.setAppointmentDate(updated.getAppointmentDate());
			return true;
		}
		
		/**
		 * Edits the Description of the Appointment Object at appointmentID
		 * Uses the setAppointmentDesc method
		 * @param appointmentID
		 * @param appointmentDesc
		 */
		public boolean editAppointmentDesc(String appointmentID, Appointment updated) {
			// Pulls the current contact in the map with the ID
			Appointment existing = (appointmentMap.get(appointmentID));
			// If the contact is not in the map, return false
			if (existing == null) return false;
			// With the appointment in the map, get the updated description and set it to the existing appointment in the database
			// then return true
			existing.setAppointmentDesc(updated.getAppointmentDesc());
			return true;
		}
}
