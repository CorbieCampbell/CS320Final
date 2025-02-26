/* CHARLES CAMPBELL
 * January 25, 2025
 * ContactServiceTest.java
 */

package Contact;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
		
	// Method to ensure that the database gets cleared after every test so each can run as expected
	@AfterEach
	void init() {
		ContactService.getInstance().contactMap.clear();
	}
	
	/**
	 * Test to make sure the instance is made
	 * and also helps make sure there is no additional instances
	 */
	@DisplayName("Get Instance Test")
	@Test
	void testGetInstance() {
		assertNotNull(ContactService.getInstance());
	}

	/**
	 * Test for adding a contact that passes the first & last name, phone, address variables
	 * and then validates they were properly filled.
	 */
	@DisplayName("Add Contact Test")
	@Test
	void testAddContact() {
		// Creates a new contact to be added to the database
		Contact contact = new Contact("1", "James", "Kirk", "1113334444", "123 Main Street");
		// Asserts that the contact was added to the database in the instance
		assertTrue(ContactService.getInstance().addContact(contact));
		// Asserts that the contact's ID contains the proper key
		assertTrue(ContactService.getInstance().contactMap.containsKey("1"));
	}
	
	/**
	* Add 3 contacts via addContact, then delete element at ID 1 
	* and check that the element is no long within the contact list
	* and the other contacts are still present.
	*/
	@DisplayName("Delete Contact Test")			  
	@Test void testDeleteContact() {
		// Creates 3 contacts
		Contact firstContact = new Contact("1", "James", "Kirk", "1113334444", "123 Main Street");
		Contact secondContact = new Contact("2", "Spock", "T'Gai", "2225557777", "541 Main Street");
		Contact thirdContact = new Contact("3", "Leonard", "McCoy", "6668889999", "709 Main Street");
		// Asserts that all the contacts were added to the instance's database
		assertTrue(ContactService.getInstance().addContact(firstContact));
		assertTrue(ContactService.getInstance().addContact(secondContact));
		assertTrue(ContactService.getInstance().addContact(thirdContact));
		// Asserts that the deletion of the first contact was successful, per the input of the contact's ID
		assertTrue(ContactService.getInstance().deleteContact("1"));
		// Double checks the database to ensure that it's false that the Hash Map contains the contact's ID
		assertFalse(ContactService.getInstance().contactMap.containsKey("1"));
		// Double checks the rest of the contacts are still present in the database
		assertTrue(ContactService.getInstance().contactMap.containsKey("2"));
		assertTrue(ContactService.getInstance().contactMap.containsKey("3"));
	}
	
	/**
	* Only add 2 tasks via addContact, then try to delete a contact that isn't in the map (NULL bucket),
	* also check if other contacts are still present.
	*/
	@DisplayName("Failed Delete Task Test")			  
	@Test void testFailedDeleteContact() {
		// Creates 2 contacts, leaving first bucket NULL
		Contact secondContact = new Contact("2", "Spock", "T'Gai", "2225557777", "541 Main Street");
		Contact thirdContact = new Contact("3", "Leonard", "McCoy", "6668889999", "709 Main Street");
		// Asserts that 2nd & 3rd tasks were added to the instance's database, and that 1st is still null
		assertTrue(ContactService.getInstance().addContact(secondContact));
		assertTrue(ContactService.getInstance().addContact(thirdContact));
		assertFalse(ContactService.getInstance().contactMap.containsKey("1"));
		// Asserts that the deletion of the first task was unsuccessful, per the input of the task's ID # 1
		assertFalse(ContactService.getInstance().deleteContact("1"));
		// Double checks the rest of the tasks are still present in the database
		assertTrue(ContactService.getInstance().contactMap.containsKey("2"));
		assertTrue(ContactService.getInstance().contactMap.containsKey("3"));
	}
	
	/**
	 * Test to ensure first name gets edited for a contact
	 * and validates if new first name was stored correctly.
	 */
	@DisplayName("Edit First Name Test")
	@Test
	void testEditFirstName() {
		// Creates a contact
		Contact contact = new Contact("1", "Luke", "Skywalker", "1234567890", "850 Ewok Lane");
		// Asserts that the contact was added to the instance's database
		assertTrue(ContactService.getInstance().addContact(contact));
		// Contact's update data, specifically the first name
		Contact updateContact = new Contact("1", "Rey", "Skywalker", "1234567890", "850 Ewok Lane");
		// Asserts that the edit function was successful and received the new input data
		assertTrue(ContactService.getInstance().editFirstName("1", updateContact));
		// Double checks the database to ensure that the contact's first name was updated to the correct value
		assertEquals("Rey", ContactService.getInstance().contactMap.get("1").getFirstName());
	}
	
	/**
	 * Test for failure of editing a first name for a NULL contact in the map;
	 * also validates if updated first name did not get put into other contacts.
	 */
	@DisplayName("Failed Edit First Name Test")
	@Test
	void testFailedEditFirstName() {
		// Creates 2 contacts, leaving first bucket NULL
		Contact secondContact = new Contact("2", "Spock", "T'Gai", "2225557777", "541 Main Street");
		Contact thirdContact = new Contact("3", "Leonard", "McCoy", "6668889999", "709 Main Street");
		// Asserts that 2nd & 3rd tasks were added to the instance's database, and that 1st is still null
		assertTrue(ContactService.getInstance().addContact(secondContact));
		assertTrue(ContactService.getInstance().addContact(thirdContact));
		assertFalse(ContactService.getInstance().contactMap.containsKey("1"));
		// Contact's update data, specifically the first name
		Contact updateContact = new Contact("1", "Luke", "Skywalker", "1234567890", "850 Ewok Lane");
		// Asserts that the edit function failed and new input data did not go into the map
		assertFalse(ContactService.getInstance().editFirstName("1", updateContact));
		// Double checks the rest of the contacts don't have the input value of the attempted update to a contact's first name
		assertNotEquals("Luke", ContactService.getInstance().contactMap.get("2").getFirstName());
		assertNotEquals("Luke", ContactService.getInstance().contactMap.get("3").getFirstName());
	}
	
	/**
	 * Test to ensure last name gets edited for a contact
	 * and validates if new last name was stored correctly.
	 */
	@DisplayName("Edit Last Name Test")
	@Test
	void testEditLastName() {
		// Creates a contact
		Contact contact = new Contact("1", "Leia", "Organa", "9998887777", "1050 Ewok Lane");
		// Asserts that the contact was added to the instance's database
		assertTrue(ContactService.getInstance().addContact(contact));
		// Contact's update data, specifically the last name
		Contact updateContact = new Contact("1", "Leia", "Solo", "9998887777", "1050 Ewok Lane");
		// Asserts that the edit function was successful and received the new input data
		assertTrue(ContactService.getInstance().editLastName("1", updateContact));
		// Double checks the database to ensure that the contact's last name was updated to the correct value
		assertEquals("Solo", ContactService.getInstance().contactMap.get("1").getLastName());
	}
	
	/**
	 * Test for failure of editing a first name for a NULL contact in the map;
	 * also validates if updated first name did not get put into other contacts.
	 */
	@DisplayName("Failed Edit Last Name Test")
	@Test
	void testFailedEditLastName() {
		// Creates 2 contacts, leaving first bucket NULL
		Contact secondContact = new Contact("2", "Spock", "T'Gai", "2225557777", "541 Main Street");
		Contact thirdContact = new Contact("3", "Leonard", "McCoy", "6668889999", "709 Main Street");
		// Asserts that 2nd & 3rd tasks were added to the instance's database, and that 1st is still null
		assertTrue(ContactService.getInstance().addContact(secondContact));
		assertTrue(ContactService.getInstance().addContact(thirdContact));
		assertFalse(ContactService.getInstance().contactMap.containsKey("1"));
		// Contact's update data, specifically the last name
		Contact updateContact = new Contact("1", "Luke", "Skywalker", "1234567890", "850 Ewok Lane");
		// Asserts that the edit function failed and new input data did not go into the map
		assertFalse(ContactService.getInstance().editLastName("1", updateContact));
		// Double checks the rest of the contacts don't have the input value of the attempted update to a contact's last name
		assertNotEquals("Skywalker", ContactService.getInstance().contactMap.get("2").getLastName());
		assertNotEquals("Skywalker", ContactService.getInstance().contactMap.get("3").getLastName());
	}
	
	/**
	 * Test to ensure phone number gets edited for a contact
	 * and validates if new phone number was stored correctly.
	 */
	@DisplayName("Edit Phone Number Test")
	@Test
	void testEditPhoneNumber() {
		// Creates a contact
		Contact contact = new Contact("1", "Darth", "Vader", "1234567890", "1000 Death Star Blvd");
		// Asserts that the contact was added to the instance's database
		assertTrue(ContactService.getInstance().addContact(contact));
		// Contact's update data, specifically the phone number
		Contact updateContact = new Contact("1", "Darth", "Vader", "0987654321", "1000 Death Star Blvd");
		// Asserts that the edit function was successful and received the new input data
		assertTrue(ContactService.getInstance().editPhoneNumber("1", updateContact));
		// Double checks the database to ensure that the contact's phone number was updated to the correct value
		assertEquals("0987654321", ContactService.getInstance().contactMap.get("1").getPhoneNumber());
	}
	
	/**
	 * Test for failure of editing a first name for a NULL contact in the map;
	 * also validates if updated first name did not get put into other contacts.
	 */
	@DisplayName("Failed Phone Number Test")
	@Test
	void testFailedEditPhoneNumber() {
		// Creates 2 contacts, leaving first bucket NULL
		Contact secondContact = new Contact("2", "Spock", "T'Gai", "2225557777", "541 Main Street");
		Contact thirdContact = new Contact("3", "Leonard", "McCoy", "6668889999", "709 Main Street");
		// Asserts that 2nd & 3rd tasks were added to the instance's database, and that 1st is still null
		assertTrue(ContactService.getInstance().addContact(secondContact));
		assertTrue(ContactService.getInstance().addContact(thirdContact));
		assertFalse(ContactService.getInstance().contactMap.containsKey("1"));
		// Contact's update data, specifically the phone number
		Contact updateContact = new Contact("1", "Luke", "Skywalker", "1234567890", "850 Ewok Lane");
		// Asserts that the edit function failed and new input data did not go into the map
		assertFalse(ContactService.getInstance().editPhoneNumber("1", updateContact));
		// Double checks the rest of the contacts don't have the input value of the attempted update to a contact's phone number
		assertNotEquals("1234567890", ContactService.getInstance().contactMap.get("2").getPhoneNumber());
		assertNotEquals("1234567890", ContactService.getInstance().contactMap.get("3").getPhoneNumber());
	}
	
	/**
	 * Test to ensure address gets edited for a contact
	 * and validates if new address was stored correctly.
	 */
	@DisplayName("Edit Street Address Test")
	@Test
	void testEditStreetAddress() {
		// Creates a contact
		Contact contact = new Contact("1", "JarJar", "Binks", "6668882222", "Gungan Swamp, Naboo");
		// Asserts that the contact was added to the instance's database
		assertTrue(ContactService.getInstance().addContact(contact));
		// Contact's update data, specifically the street address
		Contact updateContact = new Contact("1", "JarJar", "Binks", "6668882222", "123 Senate Circle, Coruscant");
		// Asserts that the edit function was successful and received the new input data
		assertTrue(ContactService.getInstance().editStreetAddress("1", updateContact));
		// Double checks the database to ensure that the contact's street address was updated to the correct value
		assertEquals("123 Senate Circle, Coruscant", ContactService.getInstance().contactMap.get("1").getStreetAddress());
	}
	
	/**
	 * Test for failure of editing a first name for a NULL contact in the map;
	 * also validates if updated first name did not get put into other contacts.
	 */
	@DisplayName("Failed Phone Number Test")
	@Test
	void testFailedEditStreetAddress() {
		// Creates 2 contacts, leaving first bucket NULL
		Contact secondContact = new Contact("2", "Spock", "T'Gai", "2225557777", "541 Main Street");
		Contact thirdContact = new Contact("3", "Leonard", "McCoy", "6668889999", "709 Main Street");
		// Asserts that 2nd & 3rd tasks were added to the instance's database, and that 1st is still null
		assertTrue(ContactService.getInstance().addContact(secondContact));
		assertTrue(ContactService.getInstance().addContact(thirdContact));
		assertFalse(ContactService.getInstance().contactMap.containsKey("1"));
		// Contact's update data, specifically the street address
		Contact updateContact = new Contact("1", "Luke", "Skywalker", "1234567890", "850 Ewok Lane");
		// Asserts that the edit function failed and new input data did not go into the map
		assertFalse(ContactService.getInstance().editStreetAddress("1", updateContact));
		// Double checks the rest of the contacts don't have the input value of the attempted update to a contact's street address
		assertNotEquals("850 Ewok Lane", ContactService.getInstance().contactMap.get("2").getStreetAddress());
		assertNotEquals("850 Ewok Lane", ContactService.getInstance().contactMap.get("3").getStreetAddress());
	}
}
