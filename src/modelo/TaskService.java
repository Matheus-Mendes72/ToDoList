package modelo;
import java.util.List;

public interface TaskService {
    // Define as regras de aplicação
    Task createTask(int id, String title, String description);

    PriorityTask createPriorityTask(int id, String title, String description, Priority priority);

    List<Task> listTasks();

    Task findTask(int id);

    void completeTask(int id);

    void deleteTask(int id);
}

