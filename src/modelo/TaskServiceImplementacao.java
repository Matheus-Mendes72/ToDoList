package modelo;
import java.util.ArrayList;
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
    public List<Task> listPendingTasks() {
        List<Task> pending = new ArrayList<>();
        
        for (Task task : repository.getAll()) {
        	if (task.getStatus() == Status.PENDENTE) {
        		pending.add(task);
        	}
        }
        if (pending.isEmpty()) {
    		throw new NoTasksConpletedException("Nenhuma tarefa pendente!");
    	}
        
        return pending;
    }
    
    @Override
    public List<Task> listCompletedTasks() {
    	List<Task> completed = new ArrayList<>();
    	
    	for (Task task : repository.getAll()) {
    		if (task.getStatus() == Status.CONCLUIDA) {
    			completed.add(task);
    		}
    	}
    	if (completed.isEmpty()) {
    		throw new NoTasksConpletedException("Nenhuma tarefa foi concluída!");
    	}
    	return completed;
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
