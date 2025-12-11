package modelo;
//import java.time.LocalDateTime; 	// importação do API de data e hora que usarei futuramente

public class Task {
	private final int id; 				// identificador imutável da tarefa
	private String title; 				// título da tarefa
	private String description; 		// descrição opcional
	private boolean completed; 			// indicador se a tarefa foi concluída
	private LocalDateTime createdAt; 	// data e hora da criação
	
	public Task(int id, String title, String description) throws ArgumentoInvalidoException {
		if (title == null) {
			throw new ArgumentoInvalidoException("Erro: Título é obrigatório");
		}
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = false;
	}
	
	public void markAsCompleted() {	// método para marcar quando a tarefa for concluída
		this.completed = true;
	}
	
	@Override
	public String toString() {
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean isCompleted() {
		return this.completed;
	}
	
	public LocalDateTime getCreatedAt() {
		
	}
}
