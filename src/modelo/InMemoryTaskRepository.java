package modelo;
import java.util.List;
import java.util.ArrayList;

public class InMemoryTaskRepository implements TaskRepository {
	private List<Task> tasks = new ArrayList<>();
	
	@Override
	public void add(Task task) {
		tasks.add(task);
	}
	
	@Override 
	public List<Task> getAll() {
		return new ArrayList<>(tasks);
	}
	
	@Override
	public Task getByIdI(int id) {
		
	}
	
	@Override void remove(int id) {
		
	}
}
