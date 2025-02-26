/* CHARLES CAMPBELL
 * February 8, 2025
 * AppointmentServiceTest.java
 */

package Appointment;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

		// Method to ensure that the database gets cleared after every test so each can run as expected
		@AfterEach
		void init() {
			AppointmentService.getInstance().appointmentMap.clear();
		}
		
		/**
		 * Test to make sure the appointment instance is made
		 * and also helps make sure there is no additional instances
		 */
		@DisplayName("Get Instance Test")
		@Test
		void testGetInstance() {
			assertNotNull(AppointmentService.getInstance());
		}

		/**
		 * Test for adding an appointment that passes the Appointment ID, date, description variables
		 * and then validates the map does have the info filled at the appropriate index.
		 */
		@DisplayName("Add Appointment Test")
		@Test
		void testAddAppointment() {
			// Creates a new appointment to be added to the database
			Appointment newAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Testing creation of the appointment's desc limits!");
			// Asserts that the appointment was added to the database in the instance
			assertTrue(AppointmentService.getInstance().addAppointment(newAppointment));
			// Asserts that the appointment's ID contains the proper key
			assertTrue(AppointmentService.getInstance().appointmentMap.containsKey("1"));
		}
		
		/**
		* Add 3 Appointment via addAppointment, then delete element at ID 1 
		* and check that the element is no longer within the Appointment map
		* and the other Appointment are still present.
		*/
		@DisplayName("Delete Appointment Test")			  
		@Test void testDeleteAppointment() {
			// Creates 3 appointments
			Appointment firstAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Mario will get a teeth cleaning.");
			Appointment secondAppointment = new Appointment("2", new Date((System.currentTimeMillis() + 86400000)), "Luigi X-Ray to check for cavities.");
			Appointment thirdAppointment = new Appointment("3", new Date((System.currentTimeMillis() + 86400000)), "Bowser will get a decayed tooth pulled.");
			// Asserts that all the Appointment were added to the instance's database
			assertTrue(AppointmentService.getInstance().addAppointment(firstAppointment));
			assertTrue(AppointmentService.getInstance().addAppointment(secondAppointment));
			assertTrue(AppointmentService.getInstance().addAppointment(thirdAppointment));
			// Asserts that the deletion of the first Appointment was successful, per the input of the Appointment's ID
			assertTrue(AppointmentService.getInstance().deleteAppointment("1"));
			// Double checks the database to ensure that it's false that the Hash Map contains the Appointment per its ID
			assertFalse(AppointmentService.getInstance().appointmentMap.containsKey("1"));
			// Double checks the rest of the Appointments are still present in the database
			assertTrue(AppointmentService.getInstance().appointmentMap.containsKey("2"));
			assertTrue(AppointmentService.getInstance().appointmentMap.containsKey("3"));
		}
		
		/**
		* Only add 2 Appointment via addAppointment, then try to delete an Appointment that isn't in the map (NULL bucket),
		* also check if other Appointments are still present.
		*/
		@DisplayName("Failed Delete Appointment Test")			  
		@Test void testFailedDeleteAppointment() {
			// Creates 2 Appointments
			Appointment secondAppointment = new Appointment("2", new Date((System.currentTimeMillis() + 86400000)), "Luigi X-Ray to check for cavities.");
			Appointment thirdAppointment = new Appointment("3", new Date((System.currentTimeMillis() + 86400000)), "Bowser will get a decayed tooth pulled.");
			// Asserts that 2nd & 3rd Appointment were added to the instance's database, and that 1st is still null
			assertTrue(AppointmentService.getInstance().addAppointment(secondAppointment));
			assertTrue(AppointmentService.getInstance().addAppointment(thirdAppointment));
			assertFalse(AppointmentService.getInstance().appointmentMap.containsKey("1"));
			// Asserts that the deletion of the first Appointment was unsuccessful, per the input of the Appointment's ID: # 1
			assertFalse(AppointmentService.getInstance().deleteAppointment("1"));
			// Double checks the rest of the Appointments are still present in the database
			assertTrue(AppointmentService.getInstance().appointmentMap.containsKey("2"));
			assertTrue(AppointmentService.getInstance().appointmentMap.containsKey("3"));
		}
		
		/**
		 * Test to ensure the date for an Appointment gets updated
		 * and validates if new Appointment date was stored correctly.
		 */
		@DisplayName("Edit Appointment Date Test")
		@Test
		void testEditAppointmentDate() {
			// Creates an Appointment
			Appointment firstAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Mario will get a teeth cleaning.");
			// Asserts that the Appointment was added to the instance's database
			assertTrue(AppointmentService.getInstance().addAppointment(firstAppointment));
			// Appointment's update data, specifically the Appointment Date which will be 2 days from the original plan
			Appointment updateAppointment = new Appointment("1", new Date((System.currentTimeMillis() + (86400000 * 2))), "Mario will get a teeth cleaning.");
			// Asserts that the edit function was successful and received the new input data
			assertTrue(AppointmentService.getInstance().editAppointmentDate("1", updateAppointment));
			// Double checks the database to ensure that the Appointment's date was updated to the correct value
			assertEquals(new Date(System.currentTimeMillis() + (86400000 * 2)), AppointmentService.getInstance().appointmentMap.get("1").getAppointmentDate());
		}
		
		/**
		 * Test to ensure that trying to edit a Appointment's date for a Appointment that isn't in the map (NULL bucket)
		 * results in a failure; also validates that other Appointment weren't incorrectly updated.
		 */
		@DisplayName("Failed Edit Appointment Date Test")
		@Test
		void testFailedEditAppointmentDate() {
			// Creates 2 Appointments, 2nd bucket of map being null
			Appointment firstAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Mario will get a teeth cleaning.");
			Appointment thirdAppointment = new Appointment("3", new Date((System.currentTimeMillis() + 86400000)), "Bowser will get a decayed tooth pulled.");
			// Asserts that the Appointments were added to the instance's database
			assertTrue(AppointmentService.getInstance().addAppointment(firstAppointment));
			assertTrue(AppointmentService.getInstance().addAppointment(thirdAppointment));
			// Update data for Appointment # 2
			Appointment updateAppointment = new Appointment("2", new Date((System.currentTimeMillis() + 86400000)), "Luigi X-Ray to check for cavities.");
			// Asserts confirmation of a false when trying to update the date of an Appointment that isn't in the map
			assertFalse(AppointmentService.getInstance().editAppointmentDate("2", updateAppointment));
			// Double checks the database to ensure that the date's of other Appointment in the map weren't updated
			assertEquals(new Date((System.currentTimeMillis() + 86400000)), AppointmentService.getInstance().appointmentMap.get("1").getAppointmentDate());
			assertEquals(new Date((System.currentTimeMillis() + 86400000)), AppointmentService.getInstance().appointmentMap.get("3").getAppointmentDate());
		}
		
		/**
		 * Test to ensure the description for an Appointment gets updated
		 * and validates if new description was stored correctly.
		 */
		@DisplayName("Edit Appointment Description Test")
		@Test
		void testEditAppointmentDesc() {
			// Creates an Appointment
			Appointment firstAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Mario will get a teeth cleaning.");
			// Asserts that the Appointment was added to the instance's database
			assertTrue(AppointmentService.getInstance().addAppointment(firstAppointment));
			// Appointment's update data, specifically the Appointment description
			Appointment updateAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Mario needs to consult dentist about a toothache.");
			// Asserts that the edit function was successful and Appointment received the new input data
			assertTrue(AppointmentService.getInstance().editAppointmentDesc("1", updateAppointment));
			// Double checks the database to ensure that the Appointment's description was updated to the correct value
			assertEquals("Mario needs to consult dentist about a toothache.", AppointmentService.getInstance().appointmentMap.get("1").getAppointmentDesc());
		}
		
		/**
		 * Test to ensure that trying to edit an Appointment's description for an Appointment that isn't in the map (NULL bucket)
		 * results in a failure; also validates that other Appointments weren't incorrectly updated.
		 */
		@DisplayName("Failed Edit Appointment Description Test")
		@Test
		void testFailedEditAppointmentDesc() {
			// Creates 2 Appointments, 2nd bucket of map being null
			Appointment firstAppointment = new Appointment("1", new Date((System.currentTimeMillis() + 86400000)), "Mario will get a teeth cleaning.");
			Appointment thirdAppointment = new Appointment("3", new Date((System.currentTimeMillis() + 86400000)), "Bowser will get a decayed tooth pulled.");
			// Asserts that the Appointment were added to the instance's database
			assertTrue(AppointmentService.getInstance().addAppointment(firstAppointment));
			assertTrue(AppointmentService.getInstance().addAppointment(thirdAppointment));
			// Update data for Appointment # 2
			Appointment updateAppointment = new Appointment("2", new Date((System.currentTimeMillis() + 86400000)), "Luigi X-Ray to check for cavities.");
			// Asserts confirmation of a false when trying to update the description of a Appointment that isn't in the map
			assertFalse(AppointmentService.getInstance().editAppointmentDesc("2", updateAppointment));
			// Double checks the database to ensure that the descriptions's of other Appointment in the map weren't updated
			assertEquals("Mario will get a teeth cleaning.", AppointmentService.getInstance().appointmentMap.get("1").getAppointmentDesc());
			assertEquals("Bowser will get a decayed tooth pulled.", AppointmentService.getInstance().appointmentMap.get("3").getAppointmentDesc());
		}
}
