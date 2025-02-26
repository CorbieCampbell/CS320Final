/* CHARLES CAMPBELL
 * January 31, 2025
 * TaskTest.java
 */

package Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TaskTest {
	
	/**
	 * Test to make sure that the Task construct is built correctly.
	 */
	@DisplayName("Successful Task Creation Test")
	@Test
	public void testSuccessfulTaskCreation() {
        // Variables for task, including ID, Name, and description which is set exactly at 50 characters (including spaces)
		String taskID = "1";
        String taskName = "Adding First Task";
        String taskDesc = "Testing creation of a task and description limits!";
		
        Task testTask = new Task(taskID, taskName, taskDesc);
        
        // Assertions that check that the created test task's values are equal to the original input values at beginning of the test.
		assertEquals(taskID, testTask.getTaskID());
		assertEquals(taskName, testTask.getTaskName());
		assertEquals(taskDesc, testTask.getTaskDesc());
	}
	
	/**
	 * Test for TASKID IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID Null Test")
	@Test
	void testNullInputForID() {
		String taskID = null;
        String taskName = "Adding First Task";
        String taskDesc = "Testing creation of a task and description limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDesc);
			});
	}
	
	/**
	 * Test for TASKID EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("ID More than 10 Characters Test")
	@Test
	void testCharacterLengthForID() {
		String taskID = "12345678910";
        String taskName = "Adding First Task";
        String taskDesc = "Testing creation of a task and description limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDesc);
			});
	}
	
	/**
	 * Test for TASK NAME IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Name Null Test")
	@Test
	void testNullInputForName() {
		String taskID = "1";
        String taskName = null;
        String taskDesc = "Testing creation of a task and description limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDesc);
			});
	}
	
	/**
	 * Test for TASK NAME EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Name More than 20 Characters Test")
	@Test
	void testCharacterLengthForName() {
		String taskID = "1";
        String taskName = "Task Name Purposefully Over Twenty Characters";
        String taskDesc = "Testing creation of a task and description limits!";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDesc);
			});
	}
	
	/**
	 * Test for TASK DESCRIPTION IS NULL
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Description Null Test")
	@Test
	void testNullInputForDescription() {
		String taskID = "1";
        String taskName = "Adding First Task";
        String taskDesc = null;
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDesc);
			});
	}
	
	/**
	 * Test for TASK DESCRIPTION EXCEEDS LENGTH
	 * Test to verify if a thrown exception occurs.
	 */
	@DisplayName("Description More than 50 Characters Test")
	@Test
	void testCharacterLengthForDescription() {
		String taskID = "1";
        String taskName = "Adding First Task";
        String taskDesc = "This description is purposefully longer than fifty characters to see if thrown exception occurs for a successful test";
        
        assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskID, taskName, taskDesc);
			});
	}
}