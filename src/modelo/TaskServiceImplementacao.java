package modelo;
import java.util.List;

public class TaskServiceImplementacao implements TaskService {

    // Injeção de dependência via construtor
    private final TaskRepository repository;

    public TaskServiceImplementacao(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task createTask(int id, String title, String description) {
        if (title == null || title == "") {
            throw new ArgumentoInvalidoException("Título é obrigatório");
        }
        Task novaTask = new Task(id, title, description);
        repository.add(novaTask);
        return novaTask;
    }

    @Override
    public PriorityTask createPriorityTask(int id, String title, String description, Priority priority) {
        if (title == null || title == "") {
            throw new ArgumentoInvalidoException("Título é obrigatório");
        }
        PriorityTask novaPriorityTask =
            new PriorityTask(id, title, description, priority);

        repository.add(novaPriorityTask);
        return novaPriorityTask;
    }

    @Override
    public List<Task> listTasks() {
        return repository.getAll();
    }

    @Override
    public Task findTask(int id) {
        return repository.getById(id);
    }

    @Override
    public void completeTask(int id) {
        Task task = repository.getById(id);
        task.markAsCompleted();
    }

    @Override
    public void deleteTask(int id) {
        repository.remove(id);
    }
}
