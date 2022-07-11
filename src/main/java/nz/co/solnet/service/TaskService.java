package nz.co.solnet.service;

import java.util.List;

import nz.co.solnet.model.Task;

//TODO javaDocs need to be added.
public interface TaskService {
	Task saveTask(Task task);
	List<Task> getAllTasks();
	List<Task> getOverDueTasks();
	Task getTaskById(long id);
	Task updateTask(Task task, long id);
	void deleteTask(long id);
}
