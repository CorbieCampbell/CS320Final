/* CHARLES CAMPBELL
 * January 25, 2025
 * ContactService.java
 */

package Contact;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ContactService {
	
	// Necessary function to ensure that the contact service only has one instance (helps make sure program is thread safe)
	private static ContactService INSTANCE;
	
	// Construction of the service (private ensures that only this instance can only create itself)
	private ContactService() {}
	
	// Synchronized (single thread) of creation of the instance; checks if there is no instance and then creates it
	public static synchronized ContactService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ContactService();
		}
		return INSTANCE;
	}
	
	// Creation of contact hash map to hold the objects
	Map<String, Contact> contactMap = new ConcurrentHashMap<>();
		
	/**
	 * Adds a contact at the list index number
	 * @param contact
	 */
	public boolean addContact(Contact contact) {
		// Method putIfAbset checks the HashMap if the index is filled or not
		// and will fill the bucket with the object if the bucket is NULL,
		// or returns a false if bucket is already filled
		return contactMap.putIfAbsent(contact.getContactID(), contact) == null;
	}
	
	/**
	 * Deletes the contact at the index ID
	 * @param contactID
	 */	
	public boolean deleteContact(String contactID) {
		return contactMap.remove(contactID) != null;
	}
	
	/**
	 * Edits the First Name of the Contact Object at contactID
	 * Uses the setFirstName method
	 * @param contactID
	 * @param firstName
	 */
	public boolean editFirstName(String contactID, Contact updated) {
		// Pulls the current contact in the map with the ID
		Contact existing = (contactMap.get(contactID));
		// If the contact is not in the map, return false
		if (existing == null) return false;
		// With the contact in the map, get the updated first name and set it to the existing contact in the database
		// then return true
		existing.setFirstName(updated.getFirstName());
		return true;
	}
	
	/**
	 * Edits the Lame Name of the Contact Object at contactID
	 * Uses the setLastName method
	 * @param contactID
	 * @param lastName
	 */
	public boolean editLastName(String contactID, Contact updated) {
		// Pulls the current contact in the map with the ID
		Contact existing = (contactMap.get(contactID));
		// If the contact is not in the map, return false
		if (existing == null) return false;
		// With the contact in the map, get the updated first name and set it to the existing contact in the database
		// then return true
		existing.setLastName(updated.getLastName());
		return true;	
	}
	
	/**
	 * Edits the Phone Number of the Contact Object at contactID
	 * Uses the setLastName method
	 * @param contactID
	 * @param phoneNumber
	 */
	public boolean editPhoneNumber(String contactID, Contact updated) {
		// Pulls the current contact in the map with the ID
		Contact existing = (contactMap.get(contactID));
		// If the contact is not in the map, return false
		if (existing == null) return false;
		// With the contact in the map, get the updated first name and set it to the existing contact in the database
		// then return true
		existing.setPhoneNumber(updated.getPhoneNumber());
		return true;
	}
	
	/**
	 * Edits the Street Address of the Contact Object at contactID
	 * Uses the setLastName method
	 * @param contactID
	 * @param streetAddress
	 */
	public boolean editStreetAddress(String contactID, Contact updated) {
		// Pulls the current contact in the map with the ID
		Contact existing = (contactMap.get(contactID));
		// If the contact is not in the map, return false
		if (existing == null) return false;
		// With the contact in the map, get the updated first name and set it to the existing contact in the database
		// then return true
		existing.setStreetAddress(updated.getStreetAddress());
		return true;	
	}
}