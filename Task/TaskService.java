/* CHARLES CAMPBELL
 * January 31, 2025
 * TaskService.java
 */

package Task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TaskService {
		// Necessary function to ensure that the contact service only has one instance (helps make sure program is thread safe)
		private static TaskService INSTANCE;
		
		// Construction of the service (private ensures that only this instance can only create itself)
		private TaskService() {}
		
		// Synchronized (single thread) of creation of the instance; checks if there is no instance and then creates it
		public static synchronized TaskService getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new TaskService();
			}
			return INSTANCE;
		}
		
		// Creation of contact list to hold the objects
		Map<String, Task> taskMap = new ConcurrentHashMap<>();
			
		/**
		 * Adds a contact at the list index number
		 * @param task
		 */
		public boolean addTask(Task task) {
			// Method putIfAbset checks the HashMap if the index is filled or not
			// and will fill the bucket with the object if the bucket is NULL,
			// or returns a false if bucket is already filled
			return taskMap.putIfAbsent(task.getTaskID(), task) == null;
		}
		
		/**
		 * Deletes the task at the index ID
		 * @param ID
		 */	
		public boolean deleteTask(String taskID) {
			return taskMap.remove(taskID) != null;
		}
		
		/**
		 * Edits the Name of the Task Object at taskID
		 * Uses the setTaskName method
		 * @param taskID
		 * @param taskName
		 */
		public boolean editTaskName(String taskID, Task updated) {
			// Pulls the current contact in the map with the ID
			Task existing = (taskMap.get(taskID));
			// If the contact is not in the map, return false
			if (existing == null) return false;
			// With the contact in the map, get the updated first name and set it to the existing contact in the database
			// then return true
			existing.setTaskName(updated.getTaskName());
			return true;
		}
		
		/**
		 * Edits the Lame Name of the Contact Object at contactID
		 * Uses the setLastName method
		 * @param taskID
		 * @param taskDesc
		 */
		public boolean editTaskDesc(String taskID, Task updated) {
			// Pulls the current contact in the map with the ID
			Task existing = (taskMap.get(taskID));
			// If the contact is not in the map, return false
			if (existing == null) return false;
			// With the task in the map, get the updated description and set it to the existing task in the database
			// then return true
			existing.setTaskDesc(updated.getTaskDesc());
			return true;
		}
}
