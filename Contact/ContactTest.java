/* CHARLES CAMPBELL
 * January 25, 2025
 * ContactTest.java
 */

package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ContactTest {
	
	/**
	 * Test to make sure that the Contact construct is built correctly.
	 */
	@DisplayName("Successful Creation of a Contact")
	@Test
	public void testSuccessfulContactCreation() {
        // Variables for the contact
		String contactID = "1";
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = "123 Main Street";
		
        // Creation of the test contact with the appropriate values in each field
        Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
        
        // Asserts that each of the test contact's values match the original input
		assertEquals(contactID, testContact.getContactID());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phoneNumber, testContact.getPhoneNumber());
		assertEquals(streetAddress, testContact.getStreetAddress());
	}
	
	/**
	 * Test for CONTACTID IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID Null Test")
	@Test
	void testNullInputForID() {
		String contactID = null;
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACTID EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID More than 10 Characters Test")
	@Test
	void testCharacterLengthForID() {
		String contactID = "12345678910";
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT FIRST NAME IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("First Name Null Test")
	@Test
	void testNullInputForFirstName() {
		String contactID = "1";
      	String firstName = null;
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT FIRST NAME EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID More than 10 Characters Test")
	@Test
	void testCharacterLengthForFirstName() {
		String contactID = "1";
      	String firstName = "CaptainJamesTiberius";
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT LAST NAME IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Last Name Null Test")
	@Test
	void testNullInputForLastName() {
		String contactID = "1";
      	String firstName = "James";
        String lastName = null;
        String phoneNumber = "1113334444";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT LAST NAME EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Last Name More than 10 Characters Test")
	@Test
	void testCharacterLengthForLastName() {
		String contactID = "1";
      	String firstName = "James";
        String lastName = "KirkCaptainOfTheEnterprise";
        String phoneNumber = "1113334444";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT PHONE NUMBER IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Phone Number Null Test")
	@Test
	void testNullInputForPhoneNumber() {
		String contactID = "1";
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = null;
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT PHONE NUMBER EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Phone Number More than 10 Characters Test")
	@Test
	void testCharacterLengthForPhoneNumber() {
		String contactID = "1";
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = "999998888877777";
        String streetAddress = "1000 Enterprise Street";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT STREET ADDRESS IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Street Address Null Test")
	@Test
	void testNullInputForStreetAddress() {
		String contactID = "1";
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = null;
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
	
	/**
	 * Test for CONTACT PHONE NUMBER EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Street Address More than 30 Characters Test")
	@Test
	void testCharacterLengthForStreetAddress() {
		String contactID = "1";
      	String firstName = "James";
        String lastName = "Kirk";
        String phoneNumber = "1113334444";
        String streetAddress = "Klingon Neutral Zone, Alpha Quadrant, 10000000 Light Years from the Sol System";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactID, firstName, lastName, phoneNumber, streetAddress);
			});
	}
}