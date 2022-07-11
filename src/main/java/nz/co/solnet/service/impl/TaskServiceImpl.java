package nz.co.solnet.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import nz.co.solnet.exception.ResourceNotFoundException;
import nz.co.solnet.model.Task;
import nz.co.solnet.repository.TaskRepository;
import nz.co.solnet.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public Task saveTask(Task task) {
		if (task.getCreationDate() == null) {
			task.setCreationDate(new Date());
		}
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	@Override
	public List<Task> getOverDueTasks() {
		return taskRepository.findOverDueTasks();
	}

	@Override
	public Task getTaskById(long id) {

		return taskRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Task", "Id", id));
		
	}

	@Override
	public Task updateTask(Task task, long id) {
		
		// we need to check whether task with given id is exist in DB or not
		Task existingTask = taskRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Task", "Id", id)); 
		
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		existingTask.setCreationDate(task.getCreationDate());
		existingTask.setDueDate(task.getDueDate());
		existingTask.setStatus(task.getStatus());
		// save existing task to DB
		taskRepository.save(existingTask);
		return existingTask;
	}

	@Override
	public void deleteTask(long id) {
		
		// check whether a task exist in a DB or not
		taskRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Task", "Id", id));
		taskRepository.deleteById(id);
	}
	
}
