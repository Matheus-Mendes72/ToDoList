package modelo;
import java.util.List;

public interface TaskRepository {
    void add(Task task);

    List<Task> getAll();

    Task getById(int id);

    void remove(int id);
}
