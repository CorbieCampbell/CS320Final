/* CHARLES CAMPBELL
 * February 8, 2025
 * AppointmentTest.java
 */

package Appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
	
	/**
	 * Test to make sure that the Appointment construct is built correctly.
	 */
	@DisplayName("Successful Appointment Creation Test")
	@Test
	public void testSuccessfulAppointmentCreation() {
        // Variables for appointment:
		// Unchangeable ID
		String appointmentID = "1";
		// Date, which is set 24 hours from the current time
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        // Description, exactly 50 characters long
        String appointmentDesc = "Testing creation of the appointment's desc limits!";
		
        Appointment testAppointment = new Appointment(appointmentID, appointmentDate, appointmentDesc);
        
        // Assertions that check that the created test appointment's values are equal to the original input values at beginning of the test.
		assertEquals(appointmentID, testAppointment.getAppointmentID());
		assertEquals(appointmentDate, testAppointment.getAppointmentDate());
		assertEquals(appointmentDesc, testAppointment.getAppointmentDesc());
	}
	
	/**
	 * Test for APPOINTMENT ID IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID Null Test")
	@Test
	void testNullInputForID() {
		String appointmentID = null;
		Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        String appointmentDesc = "Testing creation of the appointment's desc limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDesc);
			});
	}
	
	/**
	 * Test for APPOINTMENT ID EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID More Than 10 Characters Test")
	@Test
	void testCharacterLengthForID() {
		String appointmentID = "12345678910";
		Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        String appointmentDesc = "Testing creation of the appointment's desc limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDesc);
			});
	}
	
	/**
	 * Test for APPOINTMENT DATE IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Date Null Test")
	@Test
	void testNullInputForName() {
		String appointmentID = "1";
		Date appointmentDate = null;
        String appointmentDesc = "Testing creation of the appointment's desc limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDesc);
			});
	}
	
	/**
	 * Test for APPOINTMENT DATE NOT IN THE FUTURE
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Date Is In The Past Test")
	@Test
	void testCharacterLengthForName() {
		String appointmentID = "1";
		Date appointmentDate = new Date(System.currentTimeMillis() - 86400000);
        String appointmentDesc = "Testing creation of the appointment's desc limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDesc);
			});
	}
	
	/**
	 * Test for APPOINTMENT DESCRIPTION IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Description Null Test")
	@Test
	void testNullInputForDescription() {
		String appointmentID = "1";
		Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        String appointmentDesc = null;
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDesc);
			});
	}
	
	/**
	 * Test for APPOINTMENT DESCRIPTION EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Description More than 50 Characters Test")
	@Test
	void testCharacterLengthForDescription() {
		String appointmentID = "1";
		Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        String appointmentDesc = "This test should exceed the fifty character limit of the appointment description.";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(appointmentID, appointmentDate, appointmentDesc);
			});
	}
}