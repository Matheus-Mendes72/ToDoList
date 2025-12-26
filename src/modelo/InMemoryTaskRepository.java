package modelo;
import java.util.List;
import java.util.ArrayList;

public class InMemoryTaskRepository implements TaskRepository {

    // Lista que armazena as tarefas em memória
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override 
    public List<Task> getAll() {
        // Retorna uma CÓPIA da lista para proteger o encapsulamento
        return new ArrayList<>(tasks);
    }

    @Override
    public Task getById(int id) {
        // Percorre a lista buscando a tarefa com o ID informado
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new NotFoundException("Tarefa " + id + " não encontrada");
    }

    @Override 
    public void remove(int id) {
        Task task = getById(id);
        tasks.remove(task);
    }
}
