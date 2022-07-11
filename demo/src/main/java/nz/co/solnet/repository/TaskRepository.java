package nz.co.solnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nz.co.solnet.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Query(value = "SELECT t FROM Task t WHERE t.dueDate < CURRENT_TIMESTAMP")
	List<Task> findOverDueTasks();
}
