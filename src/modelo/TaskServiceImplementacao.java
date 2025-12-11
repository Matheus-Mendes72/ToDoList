package modelo;
import java.util.List;

public class TaskServiceImplementacao implements TaskService {
	private final TaskRepository repository;
	
	public TaskServiceImplementacao(TaskRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Task createTask(int id, String title, String description) {
		
	}
	
	@Override
	public PriorityTask createPriorityTask(int id, String title, String description, Priority priority) {
		
	}
	
	@Override
	public List<Task> listtasks() {
		
	}
	
	@Override
	public Task findTask(int id) {
		
	}
	
	@Override
	public void completeTask(int id) {
		
	}
	
	@Override
	public void deleteTask(int id) {
		
	}
}
