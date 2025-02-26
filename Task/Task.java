/* CHARLES CAMPBELL
 * January 31, 2025
 * Task.java
 */

package Task;

public class Task {
	private String taskID;
	private String taskName;
	private String taskDesc;
	
	// CONSTRUCTORS
	/*
	 * Constructor takes task ID, task name, and task description as parameters. 
	 * All parameters are checked if null or empty. If either exists, the field is filled
	 * with the phrase "NULL" to protect data integrity as a placeholder. Task ID is truncated 
	 * to a maximum of 10 characters, task name to 20 characters, and description to 50 characters.
	 * 
	 */
	public Task(String taskID, String taskName, String taskDesc) {
		/* Calls setter functions to validate each variable has appropriate requirements and gets set to constructor class */
		setTaskID(taskID);
			
		setTaskName(taskName);
		
		setTaskDesc(taskDesc);
	}
	
	

	/* GETTERS
	 * These functions are utilized for the TaskService class, for pulling task data
	 */
	
	// TASK ID
	public String getTaskID() {
		return taskID;
	}
	
	// TASK NAME
	public String getTaskName() {
		return taskName;
	}
	
	// TASK DESCRIPTION
	public String getTaskDesc() {
		return taskDesc;
	}
	
	/* SETTERS
	 * These functions are utilized to check each variable meets specific requirements, before adding data to the constructor class,
	 * and is also used for the the ContactService functions, for updating contact data correctly
	 */
	
	// Special private setter for TASK ID
	private void setTaskID(String taskID) {
		if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		else {
			this.taskID = taskID;
		}
	}
	
	// TASK NAME
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		else {
			this.taskName = taskName;
		}
	}
	
	// TASK DESCRIPTION
	public void setTaskDesc(String taskDesc) {
		if (taskDesc == null || taskDesc.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		else {
			this.taskDesc = taskDesc;
		}
	}
}