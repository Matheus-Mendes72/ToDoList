package modelo;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class InMemoryTaskRepository implements TaskRepository {

    // Lista que armazena as tarefas em memória
    private Map<Integer, Task> tasks = new HashMap<>();

    @Override
    public void add(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override 
    public List<Task> getAll() {
        // Retorna uma CÓPIA da lista para proteger o encapsulamento
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task getById(int id) {
        Task task = tasks.get(id);
        if (task == null) {
        	throw new NotFoundException("Tarefa " + id + " não encontrada");
        }
        return task;
    }

    @Override 
    public void remove(int id) {
        Task task = getById(id);
        tasks.remove(id, task);
    }
}
