package modelo;
import java.util.List;

public interface TaskService {
    // Define as regras de aplicação
    Task createTask(int id, String title, String description);

    PriorityTask createPriorityTask(int id, String title, String description, Priority priority, String senha);

    List<Task> listPendingTasks();
    
    List<Task> listCompletedTasks();

    Task findTask(int id);

    void completeTask(int id, String senha);

    void deleteTask(int id);
}

