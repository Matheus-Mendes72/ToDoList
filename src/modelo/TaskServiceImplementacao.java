package modelo;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImplementacao implements TaskService {

    // Injeção de dependência via construtor
    private final TaskRepository repository;

    public TaskServiceImplementacao(TaskRepository repository) {
        this.repository = repository;
    }
    
    public void validarTitulo(String title) {
        if (title == null || title == "") {
            throw new ArgumentoInvalidoException("Título é obrigatório");
        }
    }

    @Override
    public Task createTask(int id, String title, String description) {
        validarTitulo(title);
        
        Task novaTask = new Task(id, title, description);
        repository.add(novaTask);
        return novaTask;
    }

    @Override
    public PriorityTask createPriorityTask(int id, String title, String description, Priority priority, String senha) {
        validarTitulo(title);
        
        
        PriorityTask novaPriorityTask =
            new PriorityTask(id, title, description, priority, senha);

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
    public void completeTask(int id, String senha) {
        Task task = repository.getById(id);
        
        if (task.getStatus() == Status.CONCLUIDA) {
        	throw new ArgumentoInvalidoException("Tarefa já concluída");
        }
        
        task.complete(senha);
    }

    @Override
    public void deleteTask(int id) {
    	Task task = repository.getById(id);
    	
    	if (!task.podeSerRemovida()) {
    		throw new ArgumentoInvalidoException("Essa tarefa não pode ser removida");
    	}
    	
    	repository.remove(id);
    }
}
