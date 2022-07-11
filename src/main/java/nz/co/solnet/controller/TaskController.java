package nz.co.solnet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nz.co.solnet.model.Task;
import nz.co.solnet.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	/**
	 * Create task REST API
	 * @param task
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<Task> saveTask(@RequestBody Task task){
		return new ResponseEntity<Task>(taskService.saveTask(task), HttpStatus.CREATED);
	}

	/**
	 * Get all tasks REST API.
	 * @return all the tasks stored in database.
	 */
	@GetMapping
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}

	/**
	 * Get over due tasks REST API.
	 * @return all the over due tasks stored in database.
	 */
	@GetMapping(value = "/overdue")
	public List<Task> getOverDueTasks(){
		return taskService.getOverDueTasks();
	}
	
	/**
	 *  Get task by id REST API
	 *  
	 * @param taskId
	 * @return
	 */
	@GetMapping("{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") long taskId){
		return new ResponseEntity<Task>(taskService.getTaskById(taskId), HttpStatus.OK);
	}

	/**
	 * Update task REST API.
	 * @param id
	 * @param task
	 * @return
	 */
	@PutMapping("{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") long id
												  ,@RequestBody Task task){
		return new ResponseEntity<Task>(taskService.updateTask(task, id), HttpStatus.OK);
	}


	/**
	 * Delete task REST API
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTask(@PathVariable("id") long id){

		// delete task from DB
		taskService.deleteTask(id);

		return new ResponseEntity<String>("Task deleted successfully!.", HttpStatus.OK);
	}

}
