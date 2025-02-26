/* CHARLES CAMPBELL
 * January 31, 2025
 * TaskServiceTest.java
 */

package Task;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

		// Method to ensure that the database gets cleared after every test so each can run as expected
		@AfterEach
		void init() {
			TaskService.getInstance().taskMap.clear();
		}
		
		/**
		 * Test to make sure the task instance is made
		 * and also helps make sure there is no additional instances
		 */
		@DisplayName("Get Instance Test")
		@Test
		void testGetInstance() {
			assertNotNull(TaskService.getInstance());
		}

		/**
		 * Test for adding a task that passes the task ID, name, description variables
		 * and then validates they were properly filled.
		 */
		@DisplayName("Add Task Test")
		@Test
		void testAddTask() {
			// Creates a new task to be added to the database
			Task task = new Task("1", "First Task", "Testing creation of a task and description limits!");
			// Asserts that the task was added to the database in the instance
			assertTrue(TaskService.getInstance().addTask(task));
			// Asserts that the task's ID contains the proper key
			assertTrue(TaskService.getInstance().taskMap.containsKey("1"));
		}
		
		/**
		* Add 3 tasks via addTask, then delete element at ID 1 
		* and check that the element is no long within the task map
		* and the other tasks are still present.
		*/
		@DisplayName("Delete Task Test")			  
		@Test void testDeleteTask() {
			// Creates 3 tasks
			Task firstTask = new Task("1", "Run 4 Laps", "Run 1 mile around the track.");
			Task secondTask = new Task("2", "Run 8 Lap", "Run 2 miles around the track.");
			Task thirdTask = new Task("3", "Run 12 Laps", "Run 3 miles around the track.");
			// Asserts that all the tasks were added to the instance's database
			assertTrue(TaskService.getInstance().addTask(firstTask));
			assertTrue(TaskService.getInstance().addTask(secondTask));
			assertTrue(TaskService.getInstance().addTask(thirdTask));
			// Asserts that the deletion of the first task was successful, per the input of the task's ID
			assertTrue(TaskService.getInstance().deleteTask("1"));
			// Double checks the database to ensure that it's false that the Hash Map contains the task per it's ID
			assertFalse(TaskService.getInstance().taskMap.containsKey("1"));
			// Double checks the rest of the tasks are still present in the database
			assertTrue(TaskService.getInstance().taskMap.containsKey("2"));
			assertTrue(TaskService.getInstance().taskMap.containsKey("3"));
		}
		
		/**
		* Only add 2 tasks via addTask, then try to delete a task that isn't in the map (NULL bucket),
		* also check if other tasks are still present.
		*/
		@DisplayName("Failed Delete Task Test")			  
		@Test void testFailedDeleteTask() {
			// Creates 2 tasks
			Task secondTask = new Task("2", "Run 8 Lap", "Run 2 miles around the track.");
			Task thirdTask = new Task("3", "Run 12 Laps", "Run 3 miles around the track.");
			// Asserts that 2nd & 3rd tasks were added to the instance's database, and that 1st is still null
			assertTrue(TaskService.getInstance().addTask(secondTask));
			assertTrue(TaskService.getInstance().addTask(thirdTask));
			assertFalse(TaskService.getInstance().taskMap.containsKey("1"));
			// Asserts that the deletion of the first task was unsuccessful, per the input of the task's ID # 1
			assertFalse(TaskService.getInstance().deleteTask("1"));
			// Double checks the rest of the tasks are still present in the database
			assertTrue(TaskService.getInstance().taskMap.containsKey("2"));
			assertTrue(TaskService.getInstance().taskMap.containsKey("3"));
		}
		
		/**
		 * Test to ensure the name for a task gets updated
		 * and validates if new task name was stored correctly.
		 */
		@DisplayName("Edit Task Name Test")
		@Test
		void testEditTaskName() {
			// Creates a task
			Task task = new Task("1", "January Coding Task", "Complete the coding assignment.");
			// Asserts that the task was added to the instance's database
			assertTrue(TaskService.getInstance().addTask(task));
			// Task's update data, specifically the task name
			Task updateTask = new Task("1", "March Coding Task", "Complete the coding assignment.");
			// Asserts that the edit function was successful and received the new input data
			assertTrue(TaskService.getInstance().editTaskName("1", updateTask));
			// Double checks the database to ensure that the task's name was updated to the correct value
			assertEquals("March Coding Task", TaskService.getInstance().taskMap.get("1").getTaskName());
		}
		
		/**
		 * Test to ensure that trying to edit a task's name for a task that isn't in the map (NULL bucket)
		 * results in a failure; also validates that other tasks weren't incorrectly updated.
		 */
		@DisplayName("Failed Edit Task Name Test")
		@Test
		void testFailedEditTaskName() {
			// Creates 2 tasks, 2nd bucket of map being null
			Task firstTask = new Task("1", "Run 4 Laps", "Run 1 mile around the track.");
			Task thirdTask = new Task("3", "Run 12 Laps", "Run 3 miles around the track.");
			// Asserts that the tasks were added to the instance's database
			assertTrue(TaskService.getInstance().addTask(firstTask));
			assertTrue(TaskService.getInstance().addTask(thirdTask));
			// Update data for Task # 2
			Task updateTask = new Task("2", "Run 8 Lap", "Run 2 miles around the track.");
			// Asserts confirmation of a false when trying to update the name of a Task that isn't in the map
			assertFalse(TaskService.getInstance().editTaskName("2", updateTask));
			// Double checks the database to ensure that the name's of other tasks in the map weren't updated
			assertEquals("Run 4 Laps", TaskService.getInstance().taskMap.get("1").getTaskName());
			assertEquals("Run 12 Laps", TaskService.getInstance().taskMap.get("3").getTaskName());
		}
		
		/**
		 * Test to ensure the description for a task gets updated
		 * and validates if new description was stored correctly.
		 */
		@DisplayName("Edit Task Descriptipon Test")
		@Test
		void testEditTaskDesc() {
			// Creates a task
			Task task = new Task("1", "January Coding Task", "Complete the coding project.");
			// Asserts that the task was added to the instance's database
			assertTrue(TaskService.getInstance().addTask(task));
			// Task's update data, specifically the task description
			Task updateTask = new Task("1", "January Coding Task", "Debug & refactor coding project.");
			// Asserts that the edit function was successful and received the new input data
			assertTrue(TaskService.getInstance().editTaskDesc("1", updateTask));
			// Double checks the database to ensure that the task's description was updated to the correct value
			assertEquals("Debug & refactor coding project.", TaskService.getInstance().taskMap.get("1").getTaskDesc());
		}
		
		/**
		 * Test to ensure that trying to edit a task's description for a task that isn't in the map (NULL bucket)
		 * results in a failure; also validates that other tasks weren't incorrectly updated.
		 */
		@DisplayName("Failed Edit Task Description Test")
		@Test
		void testFailedEditTaskDesc() {
			// Creates 2 tasks, 2nd bucket of map being null
			Task firstTask = new Task("1", "Run 4 Laps", "Run 1 mile around the track.");
			Task thirdTask = new Task("3", "Run 12 Laps", "Run 3 miles around the track.");
			// Asserts that the tasks were added to the instance's database
			assertTrue(TaskService.getInstance().addTask(firstTask));
			assertTrue(TaskService.getInstance().addTask(thirdTask));
			// Update data for Task # 2
			Task updateTask = new Task("2", "Run 8 Lap", "Run 2 miles around the track.");
			// Asserts confirmation of a false when trying to update the name of a Task that isn't in the map
			assertFalse(TaskService.getInstance().editTaskDesc("2", updateTask));
			// Double checks the database to ensure that the name's of other tasks in the map weren't updated
			assertEquals("Run 1 mile around the track.", TaskService.getInstance().taskMap.get("1").getTaskDesc());
			assertEquals("Run 3 miles around the track.", TaskService.getInstance().taskMap.get("3").getTaskDesc());
		}
}
