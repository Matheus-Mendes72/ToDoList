package modelo;
import java.util.List;

public interface TaskRepository {
	void add(Task task);
	List<Task> getAll();
	public Task getById(int id);
	public void remove(int id);
}
