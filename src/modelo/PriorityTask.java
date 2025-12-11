package modelo;

public class PriorityTask extends Task {
	private Priority priority; // Define a prioridade da tarefa2
	
	public PriorityTask(int id, String title, String description, Priority priority) throws ArgumentoInvalidoException {
		super(id, title, description);
		
		if (priority != Priority.BAIXA && priority != Priority.MEDIA && priority != Priority.ALTA) {
			throw new ArgumentoInvalidoException("Prioridade deve ser apenas: 1(BAIXA), 2(MEDIA) e 3(ALTA).");
		}
		
		this.priority = priority;
	}
	
	public Priority getPriority() {
		return this.priority;
	}
	
	public void setPriority(Priority priority) throws ArgumentoInvalidoException {
		if (priority != Priority.BAIXA && priority != Priority.MEDIA && priority != Priority.ALTA) {
			throw new ArgumentoInvalidoException("Prioridade deve ser apenas: 1(BAIXA), 2(MEDIA) e 3(ALTA).");
		}
		
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | Prioridade: " + this.priority;
	}
}
