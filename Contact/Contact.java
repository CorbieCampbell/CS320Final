/* CHARLES CAMPBELL
 * January 25, 2025
 * Contact.java
 */

package Contact;

public class Contact {
	
	// Initialize variables for the contact class
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String streetAddress;
	
	/* CONSTRUCTOR
	 * Assigns variables to the contact.
	 * Additionally, verifies variables are within specified requirements,
	 * and will input filler data for any NULL input or anything that goes over limits.
	 */
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String streetAddress) {
		
		/* Calls setter functions to validate each variable has appropriate requirements and gets set to constructor class */
		setContactID(contactID);
		
		setFirstName(firstName);
		
		setLastName(lastName);
		
		setPhoneNumber(phoneNumber);
		
		setStreetAddress(streetAddress);
		
	}
	
	/* GETTERS
	 * These functions are utilized for the ContactService class, for pulling contact data
	 */
	
	// CONTACT ID
	public String getContactID() {
		return contactID;
	}
	
	// FIRST NAME
	public String getFirstName() {
		return firstName;
	}
	
	// LAST NAME
	public String getLastName() {
		return lastName;
	}
	
	// PHONE NUMBER
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	// STREET ADDRESS
	public String getStreetAddress() {
		return streetAddress;
	}
	
	/* SETTERS
	 * These functions are utilized to check each variable meets specific requirements, before adding data to the constructor class,
	 * and is also used for the the ContactService functions, for updating contact data correctly
	 */
	
	// Special private setter, helps ensure that the non-updatable ID gets assigned to a contact
	private void setContactID(String contactID) {
		if(contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		else {
			this.contactID = contactID;
		}
	}
	
	// FIRST NAME
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		else {
			this.firstName = firstName;
		}
	}

	// LAST NAME
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		else {
			this.lastName = lastName;
		}
	}

	// PHONE NUMBER
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.length() > 10 || (!phoneNumber.matches("\\d{10}"))) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		else {
			this.phoneNumber = phoneNumber;
		}
	}

	// STREET ADDRESS
	public void setStreetAddress(String streetAddress) {
		if(streetAddress == null || streetAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		else {
			this.streetAddress = streetAddress;
		}
	}
}
