package modelo;
import java.util.Scanner;

public class Menu {

    // Camada de apresentação (interface com o usuário)
    private final TaskService service;
    private final Scanner leitor = new Scanner(System.in);
    int nextID = 1;

    public Menu() {
        // Criação do serviço com repositório em memória
        this.service = new TaskServiceImplementacao(
            new InMemoryTaskRepository()
        );
    }

    public void Display() {
        // Loop principal do menu
        while (true) {
            System.out.println("=== To Do List ===");
            System.out.println("1 - Criar uma tarefa");
            System.out.println("2 - Criar tarefa com prioridade");
            System.out.println("3 - Listar tarefas");
            System.out.println("4 - Completar tarefa");
            System.out.println("5 - Remover Tarefa");
            System.out.println("0 - Sair");

            String UserChoice = leitor.nextLine();

            try {
                switch (UserChoice) {
                    case "1": CreateTask(); break;
                    case "2": CreatePriorityTask(); break;
                    case "3": List(); break;
                    case "4": Complete(); break;
                    case "5": Remove(); break;
                    case "0": return;
                    default: System.out.println("Opção Inválida");
                }
            } catch (NotFoundException | ArgumentoInvalidoException e) {
                // Tratamento centralizado de erros
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    public void CreateTask() {
    	System.out.print("Título: "); 
    	String title = leitor.nextLine(); 
    	System.out.print("Descrição: "); 
    	String description = leitor.nextLine(); 
    	service.createTask(nextID++, title, description); 
    	System.out.println("Tarefa criada!");
    }
    
    public void CreatePriorityTask() { 
    	System.out.print("Título: "); 
    	String title = leitor.nextLine(); 
    	System.out.print("Descrição: "); 
    	String description = leitor.nextLine(); 
    	System.out.println("Prioridade:"); 
    	System.out.println("1 - Baixa"); 
    	System.out.println("2 - Média"); 
    	System.out.println("3 - Alta"); 
    	System.out.print("Escolha a prioridade para a tarefa: "); 
    	int priority = Integer.parseInt(leitor.nextLine()); 
    	Priority pr;
    	
    	switch (priority) { 
    	case 1: 
    		pr = Priority.BAIXA; 
    		break; 
    	case 2: 
    		pr = Priority.MEDIA; 
    		break; 
    	case 3: 
    		pr = Priority.ALTA; 
    		break; 
    	default: 
    		System.out.println("Prioridade inválida!"); 
    		return; 
    	}
    	
    	service.createPriorityTask(nextID++, title, description, pr); 
    	System.out.println("Tarefa com prioridade criada!"); 
    }
    
    public void List() { 
    	System.out.println("--- LISTA DE TAREFAS ---"); 
    	for (Task t : service.listTasks()) { 
    		System.out.println(t); 
    	} 
    }
    
    public void Complete() { 
    	System.out.print("ID da tarefa: "); 
    	int id = Integer.parseInt(leitor.nextLine()); 
    	service.completeTask(id); 
    	System.out.println("Tarefa Completada!"); 
    }
    
    public void Remove() {
    	System.out.print("ID da tarefa: "); 
    	int id = Integer.parseInt(leitor.nextLine()); 
    	service.deleteTask(id); 
    	System.out.println("Tarefa Removida!");
    }
}

