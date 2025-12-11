package modelo;
import java.util.List;

public interface TaskService {
	public Task createTask(int id, String title, String description);
	public PriorityTask createPriorityTask(int id, String title, String description, Priority priority);
	public List<Task> listtasks;
	public Task findTask(int id);
	public void completeTask(int id);
	public void deleteTask(int id);
}
